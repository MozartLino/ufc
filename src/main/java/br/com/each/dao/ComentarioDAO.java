package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Comentario;
import br.com.each.model.Perfil;
import br.com.each.model.Usuario;

@Component
public class ComentarioDAO {

	private Connection connection;
	private PreparedStatement pstm;

	public ComentarioDAO() {
	}

	public void salva(Comentario comentario) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into tb_comentario (cod_usuario, cod_confronto, descricao, data) values (?,?,?,?)");
			pstm.setLong(1, comentario.getUsuario().getId());
			pstm.setLong(2, comentario.getConfrontoId());
			pstm.setString(3, comentario.getDescricao());
			pstm.setDate(4, comentario.getData());

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Comentario comentario) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("update tb_comentario set cod_usuario = ?, cod_confronto = ?, descricao = ?, data = ? where cod_comentario = ?");
			pstm.setLong(1, comentario.getUsuario().getId());
			pstm.setLong(2, comentario.getConfrontoId());
			pstm.setString(3, comentario.getDescricao());
			pstm.setDate(4, comentario.getData());

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
			pstm = this.connection
					.prepareStatement("delete from tb_comentario where cod_comentario = ?");
			pstm.setLong(1, id);
			pstm.executeUpdate();
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Comentario> listaPorConfronto(Long id) {
		List<Comentario> comentarios = new ArrayList<Comentario>();
		Comentario comentario = null;
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("SELECT cod_comentario, cod_confronto, descricao, data, u.cod_usuario, u.cpf, u.nome, u.login, u.senha, u.email, u.cod_perfil FROM tb_comentario c INNER JOIN tb_usuario u ON c.cod_usuario = u.cod_usuario WHERE cod_confronto = ?");
			pstm.setLong(1, id);
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Usuario usuario = new Usuario(set.getString("nome"),
						set.getDate("dataNascimento"), set.getString("cpf"),
						set.getString("email"), set.getString("login"),
						Perfil.valueOf(set.getString("perfil")));
				usuario.setId(set.getLong("cod_usuario"));

				comentario = new Comentario(set.getString("descricao"),
						set.getLong("cod_confronto"));
				comentario.setData(set.getDate("data"));
				comentario.setId(set.getLong("cod_comentario"));
				comentario.setUsuario(usuario);

				comentarios.add(comentario);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return comentarios;
	}

}