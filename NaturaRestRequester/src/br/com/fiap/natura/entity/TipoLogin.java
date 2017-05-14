package br.com.fiap.natura.entity;

public enum TipoLogin {

	NORMAL("NORMAL"), FACEBOOK("FACEBOOK");

	private final String label;

	private TipoLogin(String label) {
	    this.label = label;
	  }

	public String getLabel() {
		return this.label;
	}
}
