package br.com.each.Controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.dao.ConfrontoDAO;
import br.com.each.model.confronto.Confronto;

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

	@Get("/confronto/novo")
	public void novo() {
	}

	@Post("confrontos/salva")
	@Consumes("application/json")
	public void salva(Confronto confronto) {
		validator.validate(confronto);
		validator.onErrorSendBadRequest();

		confrontoDAO.salva(confronto);
		result.nothing();
	}

	@Delete("confrontos/remove/{id}")
	public void remove(int id) {
		confrontoDAO.remove(id);
		result.nothing();
	}

	@Get("/confrontos/{id}")
	public void confronto(Long id) {
		result.use(Results.json())
				.withoutRoot()
				.from(confrontoDAO.buscaPoId(id))
				.include("lutador1", "lutador2")
				.serialize();
	}

	@Get("/confrontos/abertos")
	public void abertos() {
		result.use(Results.json()).withoutRoot().from(confrontoDAO.abertos()).include("lutador1", "lutador2")
				.serialize();
	}

}