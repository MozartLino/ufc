package br.com.each.model.confronto;

public enum Status {

	ABERTO("ABERTO"), FECHADO("FECHADO"), FINALIZADO("FINALIZADO");

	public String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}

}
