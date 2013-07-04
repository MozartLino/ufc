package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.each.dao.ComentarioDAO;
import br.com.each.model.Comentario;
import br.com.each.model.UserSession;

@Resource
public class ComentarioController {

	private Result result;
	private ComentarioDAO comentarioDAO;
	private UserSession session;

	public ComentarioController(Result result, ComentarioDAO comentarioDAO, UserSession session) {
		this.result = result;
		this.comentarioDAO = comentarioDAO;
		this.session = session;
	}

	@Post("/comentario/salva")
	@Consumes("application/json")
	public void salva(Comentario comentario) {
		comentario.setUsuario(session.getUsuario());
		comentarioDAO.salva(comentario);
		result.use(Results.json()).withoutRoot().from(comentario).include("usuario").serialize();
	}

	@Delete("comentario/remove/{comentario.id}")
	public void remove(Comentario comentario) {
		comentarioDAO.remove(comentario.getId());
		result.nothing();
	}

	@Get("/confronto/{id}/comentario")
	public List<Comentario> listaPorConfronto(Long id) {
		return comentarioDAO.listaPorConfronto(id);
	}

}