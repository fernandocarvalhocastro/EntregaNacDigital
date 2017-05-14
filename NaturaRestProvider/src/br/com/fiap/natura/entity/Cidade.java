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

@Entity
@Table(name="T_NAT_CIDADE")
@SequenceGenerator(name="seqCidade",sequenceName="SQ_CIDADE", allocationSize=1)
public class Cidade {
	
	@Id
	@GeneratedValue(generator="seqCidade",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_cidade")
	private int codigo;
	
	@Column(name="nm_cidade",nullable=false,length=50)
	private String nome;

	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_estado")
	private Estado estado;
	
	@OneToMany(mappedBy="cidade", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Bairro> bairros;
	
	public void adicionarBairro(Bairro bairro){
		bairro.setCidade(this);
		bairros.add(bairro);
		this.setBairros(bairros);
	}
	
	public Cidade() {
		super();
		// TODO Auto-generated constructor stub
		bairros = new ArrayList<Bairro>();
	}
	
	

	public Cidade(String nome, Estado estado, List<Bairro> bairros) {
		super();
		this.nome = nome;
		this.estado = estado;
		this.bairros = bairros;bairros = new ArrayList<Bairro>();
		
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

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public List<Bairro> getBairros() {
		return bairros;
	}

	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
	}

}
