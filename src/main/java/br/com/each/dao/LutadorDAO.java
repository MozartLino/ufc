package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Lutador;

@Component
public class LutadorDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public LutadorDAO() {
	}

	public void salva(Lutador lutador) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("insert into tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values (?,?,?,?,?,?,?,?)");
			pstm.setString(1, lutador.getNome());
			pstm.setInt(2, lutador.getPeso());
			pstm.setInt(3, lutador.getEnvergadura());
			pstm.setInt(4, lutador.getAltura());
			pstm.setInt(5, lutador.getCinturao());
			pstm.setDate(6, lutador.getDataNascimento());
			pstm.setString(7, lutador.getLugar());
			pstm.setString(8, lutador.getSumario());

			pstm.execute();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Lutador lutador) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("update tb_lutador set (nome = ?, peso = ?, envergadura = ?, altura = ?, cinturao = ?, data_nascimento = ?, lugar = ?, sumario = ?) where cod_lutador = ?");
			pstm.setString(1, lutador.getNome());
			pstm.setInt(2, lutador.getPeso());
			pstm.setInt(3, lutador.getEnvergadura());
			pstm.setInt(4, lutador.getAltura());
			pstm.setInt(5, lutador.getCinturao());
			pstm.setDate(6, lutador.getDataNascimento());
			pstm.setString(7, lutador.getLugar());
			pstm.setString(8, lutador.getSumario());
			pstm.setLong(8, lutador.getId());

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
			pstm = this.connection.prepareStatement("delete from tb_usuario where cod_lutador = ?");
			pstm.setLong(1, id);
			pstm.execute();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Lutador> lista() {
		List<Lutador> lutadores = new ArrayList<Lutador>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("select * from tb_lutador");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Lutador lutador = createLutador(set);
				lutadores.add(lutador);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lutadores;
	}

	public Lutador buscaPoId(int id) {
		Lutador lutador = null;
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("select * from tb_lutador where cod_lutador = ?");
			pstm.setInt(1, id);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				lutador = createLutador(set);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return lutador;
	}

	private Lutador createLutador(ResultSet set) throws SQLException {
		Lutador lutador = new Lutador(set.getString("nome"), set.getInt("peso"), set.getInt("envergadura"), set.getInt("altura"), set.getInt("cinturao"), set.getDate("data_nascimento"), set.getString("lugar"), set.getString("sumario"));
		lutador.setId(set.getLong("cod_lutador"));
		return lutador;
	}

}