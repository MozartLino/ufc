package br.com.each.Controller;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Put;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;
import br.com.each.dao.ApostaDAO;
import br.com.each.model.Aposta;
import br.com.each.model.usuario.UserSession;

@Resource
public class ApostaController {

	private Result result;
	private ApostaDAO apostaDAO;
	private UserSession session;

	public ApostaController(Result result, ApostaDAO apostaDAO, UserSession session) {
		this.result = result;
		this.apostaDAO = apostaDAO;
		this.session = session;
	}

	@Post("aposta/salva")
	@Consumes("application/json")
	public void salva(Aposta aposta) {
		aposta.setUsuario(session.getUsuario());
		apostaDAO.salva(aposta);
		result.use(Results.status()).ok();
	}

	@Put("aposta/altera")
	@Consumes("application/json")
	public void altera(Aposta aposta) {
		apostaDAO.altera(aposta);
		result.use(Results.status()).ok();
	}

}