package br.com.each.model.confronto;

import java.sql.Date;

import br.com.each.model.Categoria;
import br.com.each.model.Lutador;
import br.com.each.model.TipoVitoria;

public class Confronto {

	private Long id;
	private String evento;
	private Date data;
	private Lutador lutador1;
	private Lutador lutador2;
	private Lutador vencedor;
	private Categoria categoria;
	private TipoVitoria tipoVitoria;
	private Status status;

	public Confronto(String evento, Date data, Lutador lutador1, Lutador lutador2, Categoria categoria, Status status) {
		this.evento = evento;
		this.data = data;
		this.lutador1 = lutador1;
		this.lutador2 = lutador2;
		this.categoria = categoria;
		this.status = status;
	}

	public Lutador getVencedor() {
		return vencedor;
	}

	public void setVencedor(Lutador vencedor) {
		this.vencedor = vencedor;
	}

	public TipoVitoria getTipoVitoria() {
		return tipoVitoria;
	}

	public void setTipoVitoria(TipoVitoria tipoVitoria) {
		this.tipoVitoria = tipoVitoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEvento() {
		return evento;
	}

	public Date getData() {
		return data;
	}

	public Lutador getLutador1() {
		return lutador1;
	}

	public Lutador getLutador2() {
		return lutador2;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public Status getStatus() {
		return status;
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
		Confronto other = (Confronto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Confronto [id=" + id + ", evento=" + evento + ", data=" + data + ", lutador1=" + lutador1 + ", lutador2=" + lutador2 + ", vencedor=" + vencedor + ", categoria=" + categoria + ", tipoVitoria=" + tipoVitoria + ", status=" + status + "]";
	}

}
