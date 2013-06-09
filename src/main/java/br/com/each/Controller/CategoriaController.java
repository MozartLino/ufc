package br.com.each.Controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.each.dao.CategoriaDAO;
import br.com.each.model.Categoria;

@Resource
public class CategoriaController {

	private Result result;
	private CategoriaDAO categoriaDAO;

	public CategoriaController(Result result, CategoriaDAO categoriaDAO) {
		this.result = result;
		this.categoriaDAO = categoriaDAO;
	}

	@Post("categorias")
	@Consumes("application/json")
	public void salva(Categoria categoria) {
		categoriaDAO.salva(categoria);
		result.nothing();
	}

	@Put("categorias")
	@Consumes("application/json")
	public void atualiza(Categoria categoria) {
		categoriaDAO.altera(categoria);
		result.redirectTo(CategoriaController.class).lista();
	}

	@Get("categorias/{id}")
	public void formulario(Long id) {
		result.use(Results.json()).withoutRoot().from(categoriaDAO.buscaPoId(id)).serialize();
	}

	@Get("/categorias")
	public void lista() {
		result.use(Results.json()).withoutRoot().from(categoriaDAO.lista()).serialize();
	}

	@Delete("categoria/remove/{id}")
	public void remove(Long id) {
		categoriaDAO.remove(id);
		result.nothing();
	}

}