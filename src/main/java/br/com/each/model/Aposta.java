package br.com.each.model;


public class Aposta {

	private Long id;
	private Long confrontoId;
	private Long lutadorId;
	private Usuario usuario;

	public Aposta(Long confrontoId, Long lutadorId) {
		this.confrontoId = confrontoId;
		this.lutadorId = lutadorId;
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

	public Long getLutadorId() {
		return lutadorId;
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
		Aposta other = (Aposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Aposta [id=" + id + ", confrontoId=" + confrontoId + ", usuario=" + usuario + ", lutadorId=" + lutadorId + "]";
	}

}