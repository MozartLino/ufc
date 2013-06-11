package br.com.each.Controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.each.dao.EventoDAO;
import br.com.each.model.confronto.Evento;

@Resource
public class EventoController {

	private Result result;
	private EventoDAO eventoDAO;

	public EventoController(Result result, EventoDAO eventoDAO) {
		this.result = result;
		this.eventoDAO = eventoDAO;
	}

	@Post("/eventos")
	@Consumes("application/json")
	public void salva(Evento evento) {
		eventoDAO.salva(evento);
		result.nothing();
	}

	@Put("/eventos")
	@Consumes("application/json")
	public void altera(Evento evento) {
		eventoDAO.altera(evento);
		result.nothing();
	}

	@Get("eventos/abertos")
	@Consumes("application/json")
	public void abertos() {
		eventoDAO.listaAbertos();
		result.nothing();
	}

	@Get("eventos/finalizados")
	@Consumes("application/json")
	public void finalizados() {
		eventoDAO.listaFinalizados();
		result.nothing();
	}

}
