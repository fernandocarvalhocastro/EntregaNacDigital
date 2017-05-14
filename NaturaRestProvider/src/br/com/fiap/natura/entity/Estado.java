package br.com.fiap.natura.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Fernando C. Castro
 * @since 29/04/2017
 * 
 * Classe que representa um Estado. Ex.: São Paulo, Rio de Janeiro, etc.
 */

@Entity
@Table(name="T_NAT_ESTADO")
@SequenceGenerator(name="seqEstado", sequenceName="SQ_ESTADO", allocationSize=1)
public class Estado {
	
	@Id
	@GeneratedValue(generator="seqEstado", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_estado")
	private int codigo;
	
	@Column(name="nm_estado")
	private String nome;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_pais",nullable=false)
	private Pais pais;
	
	@OneToMany(mappedBy="estado",cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Cidade> cidades = new ArrayList<Cidade>();
	
	public void adicionarCidade(Cidade cidade){
		cidade.setEstado(this);
		cidades.add(cidade);
		this.setCidades(cidades);
	}
	
	public Estado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estado(String nome, Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Estado(String nome) {
		super();
		this.nome = nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pais getPais() {
		return pais;
	}

	public void setPais(Pais pais) {
		this.pais = pais;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
		this.cidades = cidades;
	}

}
