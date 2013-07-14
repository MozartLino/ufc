package br.com.each.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EventoPayload {

	private PreparedStatement pstm;
	private Connection connection;

	public EventoPayload(PreparedStatement pstm, Connection connection) {
		this.pstm = pstm;
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException {
		new EventoPayload(null, null).createEventos();
	}

	public void createEventos() throws SQLException {

		for (int i = 0; i < 50; i++) {

			pstm = this.connection.prepareStatement("INSERT INTO tb_evento (descricao, status) values('UFC 151', 'FECHADO');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_evento (descricao, status) values('UFC 152', 'ABERTO');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_evento (descricao, status) values('UFC 153', 'ABERTO');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_evento (descricao, status) values('UFC 154', 'ABERTO');");
			pstm.execute();

		}

	}

}
