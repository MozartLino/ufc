package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Categoria;

@Component
public class CategoriaDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public CategoriaDAO() {
	}

	public void salva(Categoria categoria) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("insert into tb_categoria (descricao , peso_maximo , peso_minimo) values (?,?,?)");
			pstm.setString(1, categoria.getDescricao());
			pstm.setInt(2, categoria.getPesoMaximo());
			pstm.setInt(3, categoria.getPesoMinimo());

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Categoria categoria) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("update tb_categoria set 	descricao = ?, peso_maximo = ?, peso_minimo = ? where cod_categoria = ?");
			pstm.setString(1, categoria.getDescricao());
			pstm.setInt(2, categoria.getPesoMaximo());
			pstm.setInt(3, categoria.getPesoMinimo());
			pstm.setLong(4, categoria.getId());

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(Long id) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("delete from tb_categoria where cod_categoria = ?");
			pstm.setLong(1, id);
			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Categoria> lista() {
		List<Categoria> categorias = new ArrayList<Categoria>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("SELECT cod_categoria, descricao, peso_maximo, peso_minimo FROM tb_categoria");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Categoria categoria = createCategoria(set);
				categorias.add(categoria);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categorias;
	}

	public Categoria buscaPoId(Long id) {
		Categoria categoria = null;
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("SELECT cod_categoria, descricao, peso_maximo, peso_minimo FROM tb_categoria where cod_categoria = ?");
			pstm.setLong(1, id);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				categoria = createCategoria(set);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return categoria;
	}

	private Categoria createCategoria(ResultSet set) throws SQLException {
		Categoria categoria = new Categoria(set.getString("descricao"), set.getInt("peso_minimo"), set.getInt("peso_maximo"));
		categoria.setId(set.getLong("cod_categoria"));
		return categoria;
	}
}