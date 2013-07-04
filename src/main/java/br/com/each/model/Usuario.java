package br.com.each.model;

import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("serial")
public class Usuario extends Pessoa implements Serializable {

	private Long id;
	private String cpf;
	private String login;
	private String senha;
	private String email;
	private Perfil perfil;

	public Usuario(String nome, Date dataNascimento, String cpf, String email,
			String login, String senha, Perfil perfil) {
		super(nome, dataNascimento);
		this.cpf = cpf;
		this.email = email;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	// construtor sem senha
	public Usuario(String nome, Date dataNascimento, String cpf, String email,
			String login, Perfil perfil) {
		super(nome, dataNascimento);
		this.cpf = cpf;
		this.email = email;
		this.login = login;
		this.perfil = perfil;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCpf() {
		return cpf;
	}

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + " nome=" + super.getNome() + ", cpf="
				+ cpf + ", login=" + login + ", senha=" + senha + ", email="
				+ email + ", perfil=" + perfil + "]";
	}

}
