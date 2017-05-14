package br.com.fiap.natura.entity;

import java.util.Calendar;

/**
 * 
 * @author Fernando C. Castro
 * @since 29/04/2017
 * 
 *        Classe de consultoras natura.
 */
public class Consultora {
	private String nome;
	private Calendar dataNascimento;
	private Sexo sexo;

	public Consultora() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

}
