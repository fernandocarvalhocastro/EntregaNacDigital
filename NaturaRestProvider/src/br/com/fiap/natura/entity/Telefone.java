package br.com.fiap.natura.entity;

/**
 * 
 * @author Fernando C. Castro
 * @since 28/04/2017
 * 
 * Classe que representa um numero de telefone. Ex.: +55 11 99999-9999
 */
public class Telefone {
	private int codigo;
	private String numero;

	public Telefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
