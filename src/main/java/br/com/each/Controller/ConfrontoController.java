package br.com.each.Controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.dao.ConfrontoDAO;
import br.com.each.model.confronto.Confronto;
import br.com.each.model.confronto.Evento;

@Resource
public class ConfrontoController {

	private Result result;

	private ConfrontoDAO confrontoDAO;

	private Validator validator;

	public ConfrontoController(Validator validator, Result result, ConfrontoDAO confrontoDAO) {
		this.validator = validator;
		this.result = result;
		this.confrontoDAO = confrontoDAO;
	}

	@Post("confrontos")
	@Consumes("application/json")
	public void salva(Confronto confronto) {
		validator.validate(confronto);
		validator.onErrorSendBadRequest();

		confrontoDAO.salva(confronto);
		result.nothing();
	}

	@Put("confrontos")
	@Consumes("application/json")
	public void altera(Confronto confronto) {
		validator.validate(confronto);
		validator.onErrorSendBadRequest();

		confrontoDAO.altera(confronto);
		result.nothing();
	}

	@Delete("confrontos/{id}")
	public void remove(int id) {
		confrontoDAO.remove(id);
		result.nothing();
	}

	@Get("/confrontos/{id}")
	public void confronto(Long id) {
		result.use(Results.json()).withoutRoot().from(confrontoDAO.buscaPoId(id)).include("lutador1", "lutador2").serialize();
	}

	@Get("/confrontos/eventos/{evento.id}")
	public void confrontos(Evento evento) {
		result.use(Results.json()).withoutRoot().from(confrontoDAO.buscaPorEvento(evento)).include("lutador1", "lutador2").serialize();
	}

}