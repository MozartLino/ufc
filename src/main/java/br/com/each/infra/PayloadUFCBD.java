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

			pstm = this.connection.prepareStatement(" DROP SCHEMA public CASCADE; Create SCHEMA public;  ");
			pstm.execute();

			// CREATE TABLE TIPO VITORIA
			pstm = this.connection.prepareStatement("CREATE TABLE tb_tipoVitoria ( " + " cod_vitoria 	SERIAL, " + " descricao 	TEXT NOT NULL, " + " pontuacao 	INT NOT NULL, " + " PRIMARY KEY(cod_vitoria));");
			pstm.execute();

			pstm = this.connection.prepareStatement("CREATE TABLE pessoa ( " + " nome					TEXT NOT NULL, " + " data_nascimento			DATE NOT NULL) ");
			pstm.execute();

			// CREATE TABLE LUTADOR
			pstm = this.connection.prepareStatement("CREATE TABLE tb_lutador ( " + " cod_lutador          SERIAL," + " peso                 INT NOT NULL, " + " envergadura          INT NOT NULL, " + " altura               INT NOT NULL, " + " cinturao             INT NOT NULL, " + " lugar                TEXT NOT NULL, " + " sumario              TEXT NOT NULL, PRIMARY KEY(cod_lutador))inherits (pessoa); ");
			pstm.execute();

			// CREATE TABLE USUARIO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_usuario (" + " cod_usuario          SERIAL," + " cpf                  VARCHAR(20) NOT NULL," + " login                VARCHAR(20) NOT NULL," + " senha                VARCHAR(20) NOT NULL," + " email                VARCHAR(40) NOT NULL," + " perfil     INT NOT NULL, PRIMARY KEY(cod_usuario))inherits (pessoa);");
			pstm.execute();

			// CREATE TABLE VIDEO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_video ( " + " cod_video 		SERIAL, " + " cod_lutador1   	INT NOT NULL, " + " cod_lutador2   	INT NOT NULL, " + " url     			TEXT NOT NULL, " + " PRIMARY KEY(cod_video), " + " FOREIGN KEY (cod_lutador1) REFERENCES tb_lutador (cod_lutador), " + " FOREIGN KEY (cod_lutador2) REFERENCES tb_lutador (cod_lutador)); ");
			pstm.execute();

			// CREATE TABLE CATEGORIA
			pstm = this.connection.prepareStatement("CREATE TABLE tb_categoria ( " + " cod_categoria        SERIAL," + " descricao            TEXT NOT NULL," + " peso_maximo          INT NOT NULL," + " peso_minimo          INT NOT NULL," + " PRIMARY KEY (cod_categoria));");
			pstm.execute();

			// CREATE TABLE EVENTO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_evento ( " + " cod_evento        	SERIAL," + " descricao           TEXT NOT NULL," + " status				TEXT NOT NULL," + " PRIMARY KEY (cod_evento));");
			pstm.execute();

			// CREATE TABLE CONFRONTO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_confronto (" + " cod_confronto        SERIAL," + " cod_evento           INT NOT NULL," + " data                 DATE NOT NULL," + " cod_lutador1         INT NOT NULL," + " cod_lutador2         INT NOT NULL," + " cod_vencedor         INT," + " cod_categoria        INT NOT NULL," + " cod_vitoria          INT," + " PRIMARY KEY (cod_confronto)," + " FOREIGN KEY (cod_evento) REFERENCES tb_evento (cod_evento)," + " FOREIGN KEY (cod_lutador1) REFERENCES tb_lutador (cod_lutador)," + " FOREIGN KEY (cod_lutador2) REFERENCES tb_lutador (cod_lutador)," + " FOREIGN KEY (cod_vencedor) REFERENCES tb_lutador (cod_lutador)," + " FOREIGN KEY (cod_vitoria) REFERENCES tb_tipoVitoria (cod_vitoria)," + " FOREIGN KEY (cod_categoria) REFERENCES tb_categoria (cod_categoria));");
			pstm.execute();

			// CREATE TABLE COMENTARIO
			pstm = this.connection.prepareStatement("CREATE TABLE tb_comentario (" + " cod_comentario       SERIAL," + " cod_usuario          BIGINT NOT NULL," + " cod_confronto        INT NOT NULL," + " descricao            TEXT NOT NULL," + " data                 TEXT NOT NULL," + " PRIMARY KEY (cod_comentario)," + " FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod_usuario)," + " FOREIGN KEY (cod_confronto) REFERENCES tb_confronto (cod_confronto));");
			pstm.execute();

			// CREATE TABLE APOSTA
			pstm = this.connection.prepareStatement("CREATE TABLE tb_aposta (" + " cod_aposta           SERIAL," + " cod_confronto        INT NOT NULL," + " cod_usuario          BIGINT NOT NULL," + " cod_lutador          INT NOT NULL," + " PRIMARY KEY (cod_aposta)," + " FOREIGN KEY (cod_usuario) REFERENCES tb_usuario (cod_usuario)," + " FOREIGN KEY (cod_confronto) REFERENCES tb_confronto (cod_confronto));");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_tipoVitoria (descricao, pontuacao) values('finalizacao', 100);");
			pstm.execute();

			new LutadorPayload(pstm, connection).createLutadores();

			pstm = this.connection.prepareStatement("INSERT INTO tb_video (cod_lutador1, cod_lutador2, url) values (1, 2, 'http://www.youtube.com/watch?v=M0OIdCpeyY8&feature=related');");
			pstm.execute();

			new UsuarioPayload(pstm, connection).createUsers();

			pstm = this.connection.prepareStatement("INSERT INTO tb_categoria (descricao, peso_maximo, peso_minimo) values('pena', 60, 73);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_categoria (descricao, peso_maximo, peso_minimo) values('meio-pesado', 90, 104);");
			pstm.execute();

			new EventoPayload(pstm, connection).createEventos();

			new ConfrontoPayload(pstm, connection).createConfrontos();
			
			new ComentarioPayload(pstm, connection).createComentarios();

			new ApostaPayload(pstm, connection).createApostas();

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