package br.com.each.infra;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import br.com.each.dao.EventoDAO;
import br.com.each.model.Evento;

public class ConfrontoPayload {

	private PreparedStatement pstm;
	private Connection connection;

	public ConfrontoPayload(PreparedStatement pstm, Connection connection) {
		this.pstm = pstm;
		this.connection = connection;
	}

	public static void main(String[] args) throws SQLException {
		new ConfrontoPayload(null, null).createConfrontos();
	}

	public void createConfrontos() throws SQLException {

		List<Evento> listaTodos = new EventoDAO().listaTodos();

		for (Evento evento : listaTodos) {

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria) values(" + evento.getId() + ", '2012/12/10', 3, 4, 1, 3, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria) values(" + evento.getId() + " , '2012/12/12', 1, 2, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria) values(" + evento.getId() + ", '2012/12/05', 1, 3, 1, 1, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria)  values(" + evento.getId() + " , '2012/12/12', 2, 4, 1, 4, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria) values(" + evento.getId() + ", '2013/03/10', 5, 6, 2, 5, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria) values(" + evento.getId() + ", '2012/12/05', 5, 7, 2, 7, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria)  values(" + evento.getId() + " , '2012/12/12', 4, 6, 1, 4, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria) values(" + evento.getId() + ", '2013/03/10', 1, 6, 2, 1, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria) values(" + evento.getId() + ", '2012/12/05', 2, 7, 2, 7, 1);");
			pstm.execute();

			pstm = this.connection.prepareStatement("INSERT INTO tb_confronto (cod_evento, data, cod_lutador1, cod_lutador2, cod_categoria, cod_vencedor, cod_vitoria)  values(" + evento.getId() + " , '2012/12/12', 4, 6, 1, 2, 1);");
			pstm.execute();

		}

	}

}
