package br.com.each.infra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class UsuarioPayload {

	private PreparedStatement pstm;
	private Connection connection;
	private List<String> nomes;

	public UsuarioPayload(PreparedStatement pstm, Connection connection) {
		this.pstm = pstm;
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException {
		new UsuarioPayload(null, null).createUsers();
	}

	public void createUsers() throws SQLException {

		pstm = this.connection.prepareStatement("INSERT INTO tb_usuario (CPF, nome, data_nascimento, login, senha, email, perfil) values(39199733832,'Victor Rodrigues', '1990/05/05', 'vicmiguel', '123abc', 'victor@usp.br', 1);");
		pstm.execute();

		pstm = this.connection.prepareStatement("INSERT INTO tb_usuario (CPF, nome, data_nascimento, login, senha, email, perfil) values(39764341837,'Ricardo Mozart Lino', '1991/03/05', 'ricardo.lino', 'xxx', 'ricardo.lino@usp.br', 1);");
		pstm.execute();

		for (int i = 0; i < 100; i++) {

			for (String nome : getNomes()) {
				String cpf = geradorDeCPFAleatorio();
				pstm = this.connection.prepareStatement("INSERT INTO tb_usuario (CPF, nome, data_nascimento, login, senha, email, perfil) values(" + cpf + ", '" + nome + "', " + "'1990/05/05', '" + nome + "" + i + "', " + "'senha default', '" + nome + "@usp.br', 2);");
				pstm.execute();
			}
		}

	}

	private String geradorDeCPFAleatorio() {
		int cpf = new Random().nextInt();

		return new Random().nextInt(4) + "" + (cpf < 0 ? cpf * (-1) : cpf);
	}

	private List<String> getNomes() {
		if (nomes == null) {

			nomes = new ArrayList<>();
			try {
				BufferedReader in = new BufferedReader(new FileReader("nomes"));
				while (in.ready()) {
					nomes.add(in.readLine());
				}
				in.close();
			} catch (IOException e) {
			}
		}

		return nomes;
	}
}
