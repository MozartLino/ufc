package br.com.each.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import br.com.each.dao.ConfrontoDAO;
import br.com.each.model.Confronto;

public class ApostaPayload {

	private PreparedStatement pstm;
	private Connection connection;

	public ApostaPayload(PreparedStatement pstm, Connection connection) {
		this.pstm = pstm;
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException {
		new ApostaPayload(null, null).createApostas();
	}

	public void createApostas() throws SQLException {
		List<Confronto> confrontos = new ConfrontoDAO().lista();
		for (int usuarioId = 1; usuarioId < 1000; usuarioId++) {

				for (Confronto confronto : confrontos) {

					Long lutadorId = confronto.getLutador1().getId();

					if (new Random().nextInt(2) == 1) {
						lutadorId = confronto.getLutador2().getId();
					}

					pstm = this.connection.prepareStatement("INSERT INTO tb_aposta " + "(cod_usuario, cod_confronto, cod_lutador) " + "values(" + usuarioId + ", " + confronto.getId() + "," + lutadorId + ")");
					pstm.execute();

			}
		}

	}
}
