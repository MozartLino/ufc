package br.com.each.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ComentarioPayload {

	private PreparedStatement pstm;
	private Connection connection;

	public ComentarioPayload(PreparedStatement pstm, Connection connection) {
		this.pstm = pstm;
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException {
		new ComentarioPayload(null, null).createComentarios();
	}

	public void createComentarios() throws SQLException {

		for (int i = 1; i < 2000; i++) {

			int usuarioId = new Random().nextInt(1000);
			if (usuarioId == 0) {
				usuarioId = 1200;
			}
			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + usuarioId + ", " + i + ", 'muito boa luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 1) + ", " + i + ", 'Doi bons lutadores, arrazaram', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 2) + ", " + i + ", 'Nunca vi uma luta dessa', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 3) + ", " + i + ", 'Excelente Luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 4) + ", " + i + ", 'A melhor luta do ano', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 5) + ", " + i + ", 'Eu acho que eh a melhor luta que jah vi na vida', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 6) + ", " + i + ", 'muito boa luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 7) + ", " + i + ", 'Doi bons lutadores, arrazaram', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 8) + ", " + i + ", 'Nunca vi uma luta dessa', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 9) + ", " + i + ", 'Excelente Luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 10) + ", " + i + ", 'A melhor luta do ano', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 11) + ", " + i + ", 'Eu acho que eh a melhor luta que jah vi na vida', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 12) + ", " + i + ", 'muito boa luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 13) + ", " + i + ", 'Doi bons lutadores, arrazaram', 14/10/2012);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(" + (usuarioId + 14) + ", " + i + ", 'Nunca vi uma luta dessa', 14/10/2012);");
			pstm.execute();

		}

	}

}
