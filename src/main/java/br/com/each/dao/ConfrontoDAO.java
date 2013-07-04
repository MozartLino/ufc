package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Categoria;
import br.com.each.model.Confronto;
import br.com.each.model.Evento;
import br.com.each.model.Lutador;
import br.com.each.model.Status;

@Component
public class ConfrontoDAO {

	private Connection connection;

	private PreparedStatement pstm;

	public ConfrontoDAO() {
	}

	public void salva(Confronto confronto) {
		try {
			this.connection = ConnectionFactory.getConnection();
			String sql = "insert into tb_confronto (cod_evento, data, cod_lutador1 , cod_lutador2 , cod_categoria, estado) values (?,?,?,?,?,?)";

			pstm = this.connection.prepareStatement(sql);

			pstm.setLong(1, confronto.getEvento().getId());
			pstm.setDate(2, confronto.getData());
			pstm.setLong(3, confronto.getLutador1().getId());
			pstm.setLong(4, confronto.getLutador2().getId());
			pstm.setLong(5, confronto.getCategoria().getId());
			pstm.setString(6, "ABERTO");

			System.out.println(connection.nativeSQL(sql));

			pstm.execute();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Confronto confronto) {

		String sql = "update tb_confronto set cod_evento = ?, data = ?, cod_lutador1 = ?, cod_lutador2 = ?, cod_vencedor = ?, cod_vitoria = ? where cod_confroto = ?";

		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement(sql);
			pstm.setLong(1, confronto.getEvento().getId());
			pstm.setDate(2, confronto.getData());
			pstm.setLong(3, confronto.getLutador1().getId());
			pstm.setLong(4, confronto.getLutador2().getId());
			pstm.setLong(5, confronto.getVencedor().getId());
			pstm.setLong(6, confronto.getTipoVitoria().getId());
			pstm.setLong(7, confronto.getId());

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void remove(int id) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("delete from tb_confronto where cod_confronto = ?");
			pstm.setLong(1, id);
			pstm.execute();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Confronto> lista() {
		List<Confronto> confrontos = new ArrayList<Confronto>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement(query() + " ORDER BY c.data desc;");
			ResultSet set = pstm.executeQuery();

			while (set.next()) {
				confrontos.add(getConfronto(set));
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return confrontos;
	}

	public List<Confronto> buscaConfrontoPor(Evento evento) {
		List<Confronto> confrontos = new ArrayList<Confronto>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement(query() + " WHERE c.cod_evento = ? ORDER BY c.data desc;");
			System.out.println(query() + " WHERE c.cod_evento = ? ORDER BY c.data desc;");
			pstm.setLong(1, evento.getId());

			ResultSet set = pstm.executeQuery();

			while (set.next()) {

				confrontos.add(getConfronto(set));
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return confrontos;
	}

	public Confronto buscaPoId(Long id) {
		Confronto confronto = null;
		try {
			this.connection = ConnectionFactory.getConnection();
			String sql = query() + "WHERE c.cod_confronto = ? ORDER BY c.data desc;";
			pstm = this.connection.prepareStatement(sql);
			pstm.setLong(1, id);
			ResultSet set = pstm.executeQuery();

			while (set.next()) {
				confronto = getConfronto(set);
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return confronto;
	}

	private Confronto getConfronto(ResultSet set) throws SQLException {

		Lutador lutador1 = new Lutador(set.getString("nome1"), set.getInt("peso1"), set.getInt("envergadura1"),
				set.getInt("altura1"), set.getInt("cinturao1"), set.getDate("data_nascimento1"),
				set.getString("lugar1"), set.getString("sumario1"));
		lutador1.setId(set.getLong("cod_lutador1"));

		Lutador lutador2 = new Lutador(set.getString("nome2"), set.getInt("peso2"), set.getInt("envergadura2"),
				set.getInt("altura2"), set.getInt("cinturao2"), set.getDate("data_nascimento2"),
				set.getString("lugar2"), set.getString("sumario2"));
		lutador2.setId(set.getLong("cod_lutador2"));

		Lutador vencedor = new Lutador(set.getString("nome_venc"), set.getInt("peso_venc"),
				set.getInt("envergadura_venc"), set.getInt("altura_venc"), set.getInt("cinturao_venc"),
				set.getDate("data_nascimento_venc"), set.getString("lugar_venc"), set.getString("sumario_venc"));
		vencedor.setId(set.getLong("cod_lutador_venc"));

		Categoria categoria = new Categoria(set.getString("descricao"), set.getInt("peso_maximo"),
				set.getInt("peso_minimo"));
		categoria.setId(set.getLong("cod_categoria"));

		Evento evento = new Evento(set.getString("evento_descricao"), Status.valueOf(set.getString("status")));
		evento.setId(set.getLong("cod_evento"));

		Confronto confronto = new Confronto(evento, set.getDate("data"), lutador1, lutador2, categoria);
		confronto.setId(set.getLong("cod_confronto"));
		confronto.setVencedor(vencedor);

		return confronto;
	}

	private String query() {
		return "SELECT c.cod_confronto, c.data, l1.cod_lutador as cod_lutador1,  l1.nome as nome1, l1.peso as peso1, l1.envergadura as envergadura1, l1.altura as altura1, l1.cinturao as cinturao1, l1.data_nascimento as data_nascimento1, l1.lugar as lugar1, l1.sumario as sumario1, l2.cod_lutador as cod_lutador2, l2.nome as nome2, l2.peso as peso2, l2.envergadura as envergadura2, l2.altura as altura2, l2.cinturao as cinturao2, l2.data_nascimento as data_nascimento2, l2.lugar as lugar2, l2.sumario as sumario2, v.cod_lutador as cod_lutador_venc, v.nome as nome_venc, v.peso as peso_venc, v.envergadura as envergadura_venc, v.altura as altura_venc, v.cinturao as cinturao_venc, v.data_nascimento as data_nascimento_venc, v.lugar as lugar_venc, v.sumario as sumario_venc, ca.cod_categoria, ca.descricao, ca.peso_maximo, ca.peso_minimo, e.cod_evento, e.descricao as evento_descricao, e.status FROM tb_confronto c LEFT JOIN tb_lutador v ON c.cod_vencedor = v.cod_lutador INNER JOIN tb_lutador l1 ON c.cod_lutador1 = l1.cod_lutador INNER JOIN tb_lutador l2 ON c.cod_lutador2 = l2.cod_lutador INNER JOIN tb_categoria ca ON c.cod_categoria = ca.cod_categoria INNER JOIN tb_evento e ON c.cod_evento = e.cod_evento";
	}
}