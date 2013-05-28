package br.com.each.Controller;

import java.util.List;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.CategoriaDAO;
import br.com.each.dao.LutadorDAO;
import br.com.each.model.Categoria;

@Resource
public class CategoriaController {

	private Result result;
	private CategoriaDAO categoriaDAO;
	private LutadorDAO lutadorDAO;

	public CategoriaController(Result result, CategoriaDAO categoriaDAO, LutadorDAO lutadorDAO) {
		this.result = result;
		this.categoriaDAO = categoriaDAO;
		this.lutadorDAO = lutadorDAO;
	}

	@Get("/categoria/formulario")
	public void formulario() {
	}

	@Post("categoria/salva")
	@Consumes("application/json")
	public void salva(Categoria categoria) {
		categoriaDAO.salva(categoria);
		result.redirectTo("/categorias");
	}

	@Get("categoria/altera/{id}")
	public Categoria formulario(Long id) {
		Categoria categoria = categoriaDAO.buscaPoId(id);
		result.include("acao", "altera");
		result.include("lutadorList", lutadorDAO.lista());
		return categoria;
	}

	@Put("categoria/altera")
	@Consumes("application/json")
	public void atualiza(Categoria categoria) {
		categoriaDAO.altera(categoria);
		result.redirectTo(CategoriaController.class).lista();
	}

	@Delete("categoria/remove/{id}")
	public void remove(Long id) {
		categoriaDAO.remove(id);
		result.nothing();
	}

	@Get("/categorias")
	public List<Categoria> lista() {
		return categoriaDAO.lista();
	}

}