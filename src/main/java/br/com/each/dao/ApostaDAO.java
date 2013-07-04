package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Aposta;
import br.com.each.model.Usuario;

@Component
public class ApostaDAO {

	private Connection connection;
	private PreparedStatement pstm;

	public ApostaDAO() {
	}

	public void salva(Aposta aposta) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("insert into tb_aposta (cod_confronto, cod_usuario, cod_lutador) values (?,?,?)");
			pstm.setLong(1, aposta.getConfrontoId());
			pstm.setLong(2, aposta.getUsuario().getId());
			pstm.setLong(3, aposta.getLutadorId());

			pstm.execute();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Aposta aposta) {
		try {
			this.connection = ConnectionFactory.getConnection();

			pstm = this.connection
					.prepareStatement("update tb_aposta set cod_confronto = ?, cod_usuario = ?, cod_lutador = ? where cod_aposta = ?");
			pstm.setLong(1, aposta.getConfrontoId());
			pstm.setLong(2, aposta.getUsuario().getId());
			pstm.setLong(3, aposta.getLutadorId());

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
			pstm = this.connection.prepareStatement("delete from tb_aposta where cod_confronto = ?");
			pstm.setLong(1, id);

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Aposta> listaPorUsuario(Long id) {
		List<Aposta> apostas = new ArrayList<Aposta>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("SELECT * FROM tb_aposta a INNER JOIN tb_usuario u on a.usuario.id = u.id WHERE cod_usuario = "
							+ id);
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return apostas;
	}

	public Aposta buscaPorConfronto(int id, Usuario usuario) {
		Aposta aposta = null;
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection
					.prepareStatement("select * from tb_aposta where cod_confronto = ? and cod_usuario = ?");
			pstm.setInt(1, id);
			pstm.setLong(2, usuario.getId());
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				// aposta = new Aposta();
				// aposta.setConfrontoId(set.getInt("cod_confronto"));
				// aposta.setUsuarioId(set.getInt("cod_usuario"));
				// aposta.setLutadorId(set.getInt("cod_lutador"));
				// aposta.setPontuacao(set.getInt("pontuacao_aposta"));
				// aposta.setVitoriaId(set.getInt("cod_vitoria"));
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return aposta;
	}
}