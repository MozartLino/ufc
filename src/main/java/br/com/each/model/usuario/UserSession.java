package br.com.each.model.usuario;

import java.io.Serializable;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.SessionScoped;

@SuppressWarnings("serial")
@Component
@SessionScoped
public class UserSession implements Serializable {

	private Usuario usuario;

	public UserSession() {
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}

}