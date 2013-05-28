package br.com.each.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.ioc.Component;
import br.com.each.ConnectionFactory.ConnectionFactory;
import br.com.each.model.Video;

@Component
public class VideosDAO {

	private Connection connection;
	private PreparedStatement pstm;

	public VideosDAO() {
		try {
			this.connection = ConnectionFactory.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void salva(Video video) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("insert into tb_video (cod_lutador1 , cod_lutador2 , url) values (?,?,?)");
			pstm.setLong(1, video.getLutador1().getId());
			pstm.setLong(2, video.getLutador2().getId());
			pstm.setString(3, video.getUrl());

			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void altera(Video video) {
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("update tb_video set cod_lutado1 = ?, cod_lutado2 = ?, url = ? where cod_video = ?");
			pstm.setLong(1, video.getLutador1().getId());
			pstm.setLong(2, video.getLutador2().getId());
			pstm.setString(4, video.getUrl());
			pstm.setLong(5, video.getId());

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
			pstm = this.connection.prepareStatement("delete from tb_video where cod_video = ?");
			pstm.setLong(1, id);
			pstm.executeUpdate();

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Video> lista() {
		List<Video> videos = new ArrayList<Video>();
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("select * from tb_video");
			ResultSet set = pstm.executeQuery();
			while (set.next()) {

				// Video video = new Video(set.getString("url"));
				// video.setId(set.getLong("cod_video"));
				//
				// videos.add(video);
			}
			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return videos;
	}

	public Video buscaPoId(int id) {
		Video video = null;
		try {
			this.connection = ConnectionFactory.getConnection();
			pstm = this.connection.prepareStatement("select * from tb_video where cod_video = ?");
			pstm.setInt(1, id);
			pstm.execute();

			ResultSet set = pstm.executeQuery();
			while (set.next()) {
				// Video video = new Video(set.getString("url"));
				// video.setId(set.getLong("cod_video"));
			}

			pstm.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return video;
	}
}