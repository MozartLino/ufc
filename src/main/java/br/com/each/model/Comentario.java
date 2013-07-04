package br.com.each.model;

import java.sql.Date;


public class Comentario {

	private Long id;
	private Long confrontoId;
	private Usuario usuario;
	private String descricao;
	private Date data;

	public Comentario(String descricao, Long confrontoId) {
		this.descricao = descricao;
		this.confrontoId = confrontoId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getConfrontoId() {
		return confrontoId;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getDescricao() {
		return descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		Comentario other = (Comentario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comentario [id=" + id + ", confrontoId=" + confrontoId + ", usuario=" + usuario + ", descricao=" + descricao + ", data=" + data + "]";
	}

}
