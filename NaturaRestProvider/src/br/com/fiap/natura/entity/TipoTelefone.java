package br.com.fiap.natura.entity;

/**
 * 
 * @author Fernando C. Castro
 * @since 28/04/2017
 * 
 * Classe que representa um tipo de telefone. Ex.: Celular, Residencial , comercial.
 */
public class TipoTelefone {
	private int codigo;
	private String descricao;

	public TipoTelefone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
