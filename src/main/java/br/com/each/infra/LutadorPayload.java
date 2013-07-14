package br.com.each.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class LutadorPayload {

	private PreparedStatement pstm;
	private Connection connection;

	public LutadorPayload(PreparedStatement pstm, Connection connection) {
		this.pstm = pstm;
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException {
		new LutadorPayload(null, null).createLutadores();
	}

	public void createLutadores() throws SQLException {

		for (int i = 0; i < 400; i++) {

			pstm = this.connection.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Victor Rodrigues', 106, 49, 180, 0, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Diego Shibata', 102, 50, 189, 1, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Leonardo Cadastro', 106, 49, 180, 0, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Ricardo Mozart Lino', 102, 50, 189, 1, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Victor Belford', 106, 49, 180, 0, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Jon Jones', 190, 50, 189, 1, '1983/05/05', 'California', 'Mtio Master');");
			pstm.execute();

		}

	}

}
