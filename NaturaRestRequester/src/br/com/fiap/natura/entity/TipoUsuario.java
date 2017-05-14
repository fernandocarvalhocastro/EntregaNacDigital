package br.com.fiap.natura.entity;

public enum TipoUsuario {

	CONSULTOR("CONSULTOR"), CLIENTE("CLIENTE");

	private final String label;

	private TipoUsuario(String label) {
		this.label = label;
	}

	public String getLabel() {
		return this.label;
	}
}
