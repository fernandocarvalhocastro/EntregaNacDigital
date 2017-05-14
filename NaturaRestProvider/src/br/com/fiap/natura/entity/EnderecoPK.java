package br.com.fiap.natura.entity;

import java.io.Serializable;

public class EnderecoPK implements Serializable{
	private int usuario;
	private int codigo; // Codigo do endereço

	public int getUsuario() {
		return usuario;
	}

	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigo;
		result = prime * result + usuario;
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
		EnderecoPK other = (EnderecoPK) obj;
		if (codigo != other.codigo)
			return false;
		if (usuario != other.usuario)
			return false;
		return true;
	}
	
	
}
