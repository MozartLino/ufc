package br.com.each.model;

public class Video {

	private Long id;
	private Lutador lutador1;
	private Lutador lutador2;
	private String url;

	public Video(Lutador lutador1, Lutador lutador2, String url) {
		this.lutador1 = lutador1;
		this.lutador2 = lutador2;
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Lutador getLutador1() {
		return lutador1;
	}

	public Lutador getLutador2() {
		return lutador2;
	}

	public String getUrl() {
		return url;
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
		Video other = (Video) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Video [id=" + id + ", lutador1=" + lutador1 + ", lutador2=" + lutador2 + ", url=" + url + "]";
	}

}