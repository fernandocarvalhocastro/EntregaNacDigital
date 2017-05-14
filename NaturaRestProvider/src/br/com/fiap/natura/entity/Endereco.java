package br.com.fiap.natura.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Fernando C. Castro
 * @since 29/04/2016
 * 
 * Classe que representa um endereço.
 */

@Entity
@Table(name="T_NAT_ENDERECO")
@IdClass(EnderecoPK.class)
public class Endereco {
	
	@Id
	@Column(name="cd_endereco")
	@SequenceGenerator(name="seqEndereco", sequenceName="SQ_ENDERECO", allocationSize=1)
	@GeneratedValue(generator="seqEndereco", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Id
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_usuario", nullable=false)
	private Usuario usuario;
	
	@Column(name="ds_complemento",length=100)
	private String complemento;
	
	@Column(name="nr_endereco",nullable=false)
	private int numero;
	
	@ManyToOne(cascade=CascadeType.PERSIST,fetch=FetchType.LAZY)
	@JoinColumn(name="nr_cep",nullable=false)
	private Logradouro logradouro;

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Logradouro getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(Logradouro logradouro) {
		this.logradouro = logradouro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
