package br.com.each.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.each.ConnectionFactory.ConnectionFactory;

public class PayloadUFCBD {

	private Connection connection;
	private PreparedStatement pstm;

	public static void main(String[] args) {
		PayloadUFCBD payloadUFCBD = new PayloadUFCBD();
		payloadUFCBD.criaConexao();
		payloadUFCBD.populaBanco();
	}

	public void populaBanco() {
		try {

			pstm = this.connection.prepareStatement("drop database makeyourbet;");
			pstm.execute();

			pstm = this.connection.prepareStatement("create database makeyourbet;");
			pstm.execute();

			pstm = this.connection.prepareStatement("use makeyourbet;");
			pstm.execute();

			// CREATE TABLE TIPO VITORIA
			pstm = this.connection.prepareStatement("CREATE TABLE tb_tipoVitoria ( "
					+ " cod_vitoria 	INT AUTO_INCREMENT, " + " descricao 	TEXT NOT NULL, "
					+ " pontuacao 	INT NOT NULL, " + " PRIMARY KEY(cod_vitoria));");
			pstm.execute();

			// CREATE TABLE LUTADOR
			pstm = this.connection.prepareStatement("CREATE TABLE tb_lutador ( "
					+ " cod_lutador          INT AUTO_INCREMENT," + " nome                 VARCHAR(50) NOT NULL, "
					+ " peso                 INT NOT NULL, " + " envergadura          INT NOT NULL, "
					+ " altura               INT NOT NULL, " + " cinturao             INT NOT NULL, "
					+ " data_nascimento      DATE NOT NULL, " + " lugar                TEXT NOT NULL, "
					+ " sumario              TEXT NOT NULL, " + " PRIMARY KEY(cod_lutador)); ");
			pstm.execute();

			// CREATE TABLE VIDEO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_video ( " + " cod_video 		INT AUTO_INCREMENT, "
					+ " cod_lutador1   	INT NOT NULL, " + " cod_lutador2   	INT NOT NULL, "
					+ " url     			TEXT NOT NULL, " + " PRIMARY KEY(cod_video), "
					+ " FOREIGN KEY (cod_lutador1) REFERENCES tb_lutador (cod_lutador), "
					+ " FOREIGN KEY (cod_lutador2) REFERENCES tb_lutador (cod_lutador)); ");
			pstm.execute();

			// CREATE TABLE USUARIO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_usuario ("
					+ " cod_usuario          BIGINT AUTO_INCREMENT," + " cpf                  VARCHAR(20) NOT NULL,"
					+ " nome                 VARCHAR(50) NOT NULL," + " login                VARCHAR(20) NOT NULL,"
					+ " senha                VARCHAR(20) NOT NULL," + " email                VARCHAR(40) NOT NULL,"
					+ " perfil     INT NOT NULL, PRIMARY KEY(cod_usuario));");
			pstm.execute();

			// CREATE TABLE CATEGORIA
			pstm = this.connection.prepareStatement("CREATE TABLE tb_categoria ( "
					+ " cod_categoria        INT AUTO_INCREMENT," + " descricao            TEXT NOT NULL,"
					+ " peso_maximo          INT NOT NULL," + " peso_minimo          INT NOT NULL,"
					+ " PRIMARY KEY (cod_categoria));");
			pstm.execute();

			// CREATE TABLE CONFRONTO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_confronto ("
					+ " cod_confronto        INT AUTO_INCREMENT," + " evento               VARCHAR(20) NOT NULL,"
					+ " data                 DATE NOT NULL," + " estado				 TEXT NOT NULL,"
					+ " cod_lutador1         INT NOT NULL," + " cod_lutador2         INT NOT NULL,"
					+ " cod_vencedor         INT," + " cod_categoria        INT NOT NULL,"
					+ " cod_vitoria          INT," + " PRIMARY KEY (cod_confronto),"
					+ " FOREIGN KEY (cod_lutador1) REFERENCES tb_lutador (cod_lutador),"
					+ " FOREIGN KEY (cod_lutador2) REFERENCES tb_lutador (cod_lutador),"
					+ " FOREIGN KEY (cod_vencedor) REFERENCES tb_lutador (cod_lutador),"
					+ " FOREIGN KEY (cod_vitoria) REFERENCES tb_tipoVitoria (cod_vitoria),"
					+ " FOREIGN KEY (cod_categoria) REFERENCES tb_categoria (cod_categoria));");
			pstm.execute();

			// CREATE TABLE COMENTARIO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_comentario ("
					+ " cod_comentario       INT AUTO_INCREMENT," + " cod_usuario          BIGINT NOT NULL,"
					+ " cod_confronto        INT NOT NULL," + " descricao            TEXT NOT NULL,"
					+ " data                 TEXT NOT NULL," + " PRIMARY KEY (cod_comentario),"
					+ " FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod_usuario),"
					+ " FOREIGN KEY (cod_confronto) REFERENCES tb_confronto (cod_confronto));");
			pstm.execute();

			// CREATE TABLE APOSTA
			pstm = this.connection.prepareStatement("CREATE TABLE tb_aposta ("
					+ " cod_aposta           INT AUTO_INCREMENT," + " cod_confronto        INT NOT NULL,"
					+ " cod_usuario          BIGINT NOT NULL," + " cod_lutador          INT NOT NULL,"
					+ " PRIMARY KEY (cod_aposta)," + " FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod_usuario),"
					+ " FOREIGN KEY (cod_confronto) REFERENCES tb_confronto (cod_confronto));");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_tipoVitoria (descricao, pontuacao) values('finalizacao', 100);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Anderson Silva', 102, 50, 189, 1, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Victor Rodrigues', 106, 49, 180, 0, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();
			pstm = this.connection
					.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Diego Shibata', 102, 50, 189, 1, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_lutador (nome, peso, envergadura, altura, cinturao, data_nascimento, lugar, sumario) values('Leonardo Cadastro', 106, 49, 180, 0, '1980/05/05', 'Sao Paulo', 'mito');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_video (cod_lutador1, cod_lutador2, url) values (1, 2, 'http://www.youtube.com/watch?v=M0OIdCpeyY8&feature=related');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_usuario (CPF, nome, login, senha, email, perfil) values(39199733832,'Victor Rodrigues', 'vicmiguel', '123abc', 'victor@usp.br', 1);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_usuario (CPF, nome, login, senha, email, perfil) values(39764341837,'Ricardo Mozart Lino', 'ricardo.lino', 'xxx', 'ricardo.lino@usp.br', 1);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_categoria (descricao, peso_maximo, peso_minimo) values('pena', 60, 73);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_categoria (descricao, peso_maximo, peso_minimo) values('meio-pesado', 90, 104);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_confronto (evento, data, cod_lutador1, cod_lutador2, cod_categoria, estado) values('UFC RIO 152', '2012/12/12', 1, 2, 1, 'ABERTO');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_confronto (evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria, estado) values('UFC RIO 152', '2012/12/10', 3, 4, 1, 3, 1, 'FINALIZADO');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_confronto (evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria, estado) values('UFC RIO 152', '2012/12/05', 1, 3, 1, 1, 1, 'FINALIZADO');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_confronto (evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria, estado)  values('UFC RIO 152', '2012/12/12', 2, 4, 1, 4, 1, 'FINALIZADO');");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(1, 1, 'muito boa luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_comentario (cod_usuario, cod_confronto, descricao, data) values(2, 1, 'Excelente Luta', 14/10/2012);");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_aposta (cod_usuario, cod_confronto, cod_lutador) values(2, 1, 1)");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_aposta (cod_usuario, cod_confronto, cod_lutador) values(1, 2, 3)");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_aposta (cod_usuario, cod_confronto, cod_lutador) values(1, 3, 1)");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_aposta (cod_usuario, cod_confronto, cod_lutador) values(2, 3, 3)");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_aposta (cod_usuario, cod_confronto, cod_lutador) values(1, 4, 4)");
			pstm.execute();

			pstm = this.connection
					.prepareStatement("INSERT INTO tb_aposta (cod_usuario, cod_confronto, cod_lutador) values(2, 4, 4)");
			pstm.execute();

			pstm.close();

			System.out.println("sucesso");
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public void criaConexao() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}