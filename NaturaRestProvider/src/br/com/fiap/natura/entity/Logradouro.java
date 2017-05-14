package br.com.fiap.natura.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/** 
 * 
 * @author Fernando C. Castro
 * @since 29/04/2017
 * 
 * Classe que representa um logradouro. Ex.: Lins de vasconcelos
 */
@Entity
@Table(name="T_NAT_LOGRADOURO")
public class Logradouro {
	@Id
	@Column(name="nr_cep")
	private String cep;
	
	@Column(name="ds_logradouro", length=200)
	private String logradouro;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_bairro")
	private Bairro bairro;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_tipo_log")
	private TipoLogradouro tipoLogradouro;
	
	@OneToMany(mappedBy="logradouro", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Endereco> enderecos = new ArrayList<Endereco>();
	
	public void adicionarEndereco(Endereco endereco){
		endereco.setLogradouro(this);
		enderecos.add(endereco);
		this.setEnderecos(enderecos);
	}
	
	
	public Logradouro() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Logradouro(String cep, String logradouro, Bairro bairro, TipoLogradouro tipoLogradouro,
			List<Endereco> enderecos) {
		super();
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.tipoLogradouro = tipoLogradouro;
		this.enderecos = enderecos;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}


	public TipoLogradouro getTipoLogradouro() {
		return tipoLogradouro;
	}


	public void setTipoLogradouro(TipoLogradouro tipoLogradouro) {
		this.tipoLogradouro = tipoLogradouro;
	}

}
