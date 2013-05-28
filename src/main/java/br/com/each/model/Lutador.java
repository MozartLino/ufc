package br.com.each.model;

import java.sql.Date;

public class Lutador {

	private Long id;
	private String nome;
	private int peso;
	private int envergadura;
	private int altura;
	private int cinturao;
	private Date dataNascimento;
	private String lugar;
	private String sumario;

	public Lutador(String nome, int peso, int envergadura, int altura, int cinturao, Date dataNascimento, String lugar, String sumario) {
		this.nome = nome;
		this.peso = peso;
		this.envergadura = envergadura;
		this.altura = altura;
		this.cinturao = cinturao;
		this.dataNascimento = dataNascimento;
		this.lugar = lugar;
		this.sumario = sumario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public int getPeso() {
		return peso;
	}

	public int getEnvergadura() {
		return envergadura;
	}

	public int getAltura() {
		return altura;
	}

	public int getCinturao() {
		return cinturao;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public String getLugar() {
		return lugar;
	}

	public String getSumario() {
		return sumario;
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
		Lutador other = (Lutador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Lutador [id=" + id + ", nome=" + nome + ", peso=" + peso + ", envergadura=" + envergadura + ", altura=" + altura + ", cinturao=" + cinturao + ", data_nascimento=" + dataNascimento + ", lugar=" + lugar + ", sumario=" + sumario + "]";
	}

}
