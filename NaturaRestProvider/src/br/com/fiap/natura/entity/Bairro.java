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
 * Classe que representa um Bairro. Ex.: Vila Mariana, Saúde, etc.
 */

@Entity
@Table(name="T_NAT_BAIRRO")
@SequenceGenerator(name="seqBairro",sequenceName="SQ_BAIRRO",allocationSize=1)
public class Bairro {
	@Id
	@GeneratedValue(generator="seqBairro",strategy=GenerationType.SEQUENCE)
	@Column(name="cd_bairro")
	private int codigo;
	
	@Column(name="nm_bairro",nullable=false, length=50)
	private String nome;
	
	@ManyToOne(cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	@JoinColumn(name="cd_cidade")
	private Cidade cidade;
	
	@OneToMany(mappedBy="bairro",cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Logradouro> logradouros = new ArrayList<Logradouro>();
	
	public void adicionarLogradouro(Logradouro logradouro){
		logradouro.setBairro(this);
		logradouros.add(logradouro);
		this.setLogradouros(logradouros);
	}

	public Bairro() {
		super();
		// TODO Auto-generated constructor stub
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

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

}
