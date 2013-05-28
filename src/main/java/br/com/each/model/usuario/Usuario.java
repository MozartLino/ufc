package br.com.each.model.usuario;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Usuario implements Serializable {

	private Long id;
	private String cpf;
	private String nome;
	private String login;
	private String senha;
	private String email;
	private int perfil;

	public Usuario() {
	}

	public String getCpf() {
		return cpf;
	}

	public String getNome() {
		return nome;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public String getEmail() {
		return email;
	}

	public int getPerfil() {
		return perfil;
	}

	public Long getId() {
		return id;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPerfil(int perfil) {
		this.perfil = perfil;
	}

}
