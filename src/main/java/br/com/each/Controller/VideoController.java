package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.LutadorDAO;
import br.com.each.dao.VideosDAO;
import br.com.each.model.Video;

@Resource
public class VideoController {

	private Result result;
	private VideosDAO videosDAO;
	private LutadorDAO lutadorDAO;

	public VideoController(Result result, VideosDAO videosDAO,
			LutadorDAO lutadorDAO) {
		this.result = result;
		this.videosDAO = videosDAO;
		this.lutadorDAO = lutadorDAO;
	}

	@Get("/video/novo")
	public void novo() {
		result.include("lutadorList", lutadorDAO.lista());
	}

	@Post("video/salva")
	public void salva(Video video) {
		videosDAO.salva(video);
		result.redirectTo(VideoController.class).lista();
	}

	@Get("video/altera/{id}")
	public void altera(int id) {
		result.include("video", videosDAO.buscaPoId(id));
		result.include("lutadorList", lutadorDAO.lista());
	}

	@Get("video/altera")
	public void atualiza(Video video) {
		videosDAO.altera(video);
		result.redirectTo(VideoController.class).lista();
	}

	@Delete("video/remove/{video.id}")
	public void remove(Video video) {
		videosDAO.remove(video.getId());
		result.nothing();
	}

	@Get("/videos")
	public List<Video> lista() {
		return videosDAO.lista();
	}

}