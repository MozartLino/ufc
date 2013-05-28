package br.com.each.model;

public class Categoria {

	private Long id;
	private String descricao;
	private int pesoMaximo;
	private int pesoMinimo;

	public Categoria(String descricao, int pesoMaximo, int pesoMinimo) {
		this.descricao = descricao;
		this.pesoMaximo = pesoMaximo;
		this.pesoMinimo = pesoMinimo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public int getPesoMaximo() {
		return pesoMaximo;
	}

	public int getPesoMinimo() {
		return pesoMinimo;
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
		Categoria other = (Categoria) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Categoria [cod_categoria=" + id + ", descricao=" + descricao + ", peso_maximo=" + pesoMaximo + ", peso_minimo=" + pesoMinimo + "]";
	}

}
