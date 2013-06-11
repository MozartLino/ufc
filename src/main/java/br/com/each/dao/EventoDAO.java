package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.confronto.Evento;
import br.com.each.model.confronto.Status;

@Component
public class EventoDAO {

	private Connection connection;
	private PreparedStatement pstm;

	public void salva(Evento evento) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("insert into tb_evento (descricao) values (?)");
			pstm.setString(1, evento.getDescricao());

			pstm.execute();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Evento evento) {
		try {
			this.connection = ConnectionFactory.getConnection();

			pstm = this.connection.prepareStatement("update tb_evento set descricao = ? where cod_evento = ?");
			pstm.setString(1, evento.getDescricao());
			pstm.setLong(2, evento.getId());

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
			pstm = this.connection.prepareStatement("delete from tb_evento where cod_evento = ?");
			pstm.setLong(1, id);

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Evento> listaAbertos() {
		List<Evento> eventos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("SELECT * FROM tb_evento WHERE status = 'ABERTO'");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Evento evento = new Evento(set.getString("descricao"), Status.valueOf(set.getString("status")));
				evento.setId(set.getLong("cod_evento"));
				eventos.add(evento);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventos;
	}

	public List<Evento> listaFinalizados() {
		List<Evento> eventos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("SELECT * FROM tb_evento WHERE status = 'FINALIZADO'");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Evento evento = new Evento(set.getString("descricao"), Status.valueOf(set.getString("status")));
				evento.setId(set.getLong("cod_evento"));
				eventos.add(evento);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventos;
	}

	public List<Evento> listaFechados() {
		List<Evento> eventos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("SELECT * FROM tb_evento WHERE status = 'FECHADO'");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Evento evento = new Evento(set.getString("descricao"), Status.valueOf(set.getString("status")));
				evento.setId(set.getLong("cod_evento"));
				eventos.add(evento);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventos;
	}

	public List<Evento> listaTodos() {
		List<Evento> eventos = new ArrayList<>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("SELECT * FROM tb_evento");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				Evento evento = new Evento(set.getString("descricao"), Status.valueOf(set.getString("status")));
				evento.setId(set.getLong("cod_evento"));
				eventos.add(evento);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return eventos;
	}

}
