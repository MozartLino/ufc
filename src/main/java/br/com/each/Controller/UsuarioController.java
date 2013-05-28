package br.com.each.Controller;

import java.io.File;

import br.com.caelum.vraptor.Consumes;
import br.com.caelum.vraptor.Delete;
import br.com.caelum.vraptor.Get;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.interceptor.multipart.UploadedFile;
import br.com.caelum.vraptor.view.Results;
import br.com.each.annotation.Public;
import br.com.each.dao.UsuarioDAO;
import br.com.each.model.usuario.UserSession;
import br.com.each.model.usuario.Usuario;
import br.com.each.mvc.FileManager;

@Resource
public class UsuarioController {

	private Result result;
	private UsuarioDAO usuarioDAO;
	private UserSession session;
	private FileManager fileManager;

	public UsuarioController(Result result, UsuarioDAO usuarioDAO, UserSession session, FileManager fileManager) {
		this.result = result;
		this.usuarioDAO = usuarioDAO;
		this.session = session;
		this.fileManager = fileManager;
	}

	@Get("usuarios")
	public void form() {
	}

	@Get("usuarios/{id}")
	public void getUser(Long id) {
		result.use(Results.json()).withoutRoot().from(usuarioDAO.buscaPoId(id)).serialize();
	}

	@Post("usuarios")
	@Consumes("application/json")
	public void salva(Usuario usuario) {
		usuarioDAO.salva(usuario);
		result.nothing();
	}

	@Delete("/usuarios/{id}")
	public void remove(Long id) {
		usuarioDAO.remove(id);
		result.nothing();
	}

	@Get("/perfil")
	public void perfil() {
		result.use(Results.json()).withoutRoot().from(usuarioDAO.buscaPoId(session.getUsuario().getId())).serialize();
	}

	@Get("/ranking")
	public void ranking() {
		result.use(Results.json()).withoutRoot().from(usuarioDAO.ranking()).serialize();
	}

	@Post("/usuarios/foto")
	public void salva(UploadedFile filename) {
		fileManager.upload(filename, "usuarios" + File.separator + session.getUsuario().getId());
		result.nothing();
	}

	@Get("/usuarios/foto")
	public File foto() {
		return fileManager.download("usuarios" + File.separator + session.getUsuario().getId());
	}

	@Public
	@Post("/logar")
	@Consumes("application/json")
	public void logar(Usuario usuario) {

		usuario = usuarioDAO.valida(usuario);

		if (usuario != null) {
			session.setUsuario(usuario);
		}

		result.redirectTo(UsuarioController.class).perfil();
	}

	@Get("/deslogar")
	public void deslogar() {
		session.setUsuario(null);
		result.nothing();
	}
}