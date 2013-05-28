package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.Validator;
import br.com.caelum.vraptor.view.Results;
import br.com.each.dao.LutadorDAO;
import br.com.each.model.Lutador;

@Resource
public class LutadorController {

	private Result result;
	private LutadorDAO lutadorDAO;
	private Validator validator;

	public LutadorController(Result result, LutadorDAO lutadorDAO, Validator validator) {
		this.result = result;
		this.lutadorDAO = lutadorDAO;
		this.validator = validator;
	}

	@Get("/lutador/novo")
	public void novo() {
	}

	@Post("lutador/salva")
	@Consumes("application/json")
	public void salva(Lutador lutador) {
		lutadorDAO.salva(lutador);
		validator.onErrorUsePageOf(LutadorController.class).novo();
		result.use(Results.status()).ok();
	}

	@Get("lutador/altera/{id}")
	public void edita(int id) {
		result.use(Results.json()).withoutRoot().from(lutadorDAO.buscaPoId(id)).serialize();
	}

	@Put("lutador/altera")
	@Consumes("application/json")
	public void atualiza(Lutador lutador) {
		lutadorDAO.altera(lutador);
		validator.onErrorUsePageOf(LutadorController.class).novo();
		result.use(Results.status()).ok();
	}

	@Delete("lutador/remove/{lutador.id}")
	public void remove(Lutador lutador) {
		lutadorDAO.remove(lutador.getId());
		result.nothing();
	}

	@Get("/lutadores")
	public List<Lutador> lista() {
		return lutadorDAO.lista();
	}

}