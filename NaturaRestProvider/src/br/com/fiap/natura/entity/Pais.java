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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Fernando C. Castro
 * @since 29/04/2017
 * 
 * Classe que representa um País. Ex:. Brasil, Colômbia, etc.
 */

@Entity
@Table(name="T_NAT_PAIS")
@SequenceGenerator(name="seqPais", sequenceName="SQ_PAIS", allocationSize=1)
public class Pais {
	@Id
	@GeneratedValue(generator="seqPais", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_pais")
	private int codigo;
	
	@Column(name="nm_pais",nullable=false,length=50)
	private String nome;
	
	@OneToMany(mappedBy="pais",cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Estado> estados;
	
	public void adicionarEstado(Estado estado){
		estado.setPais(this);
		estados.add(estado);
		this.setEstados(estados);
	}

	public Pais() {
		super();
		estados = new ArrayList<Estado>();
		// TODO Auto-generated constructor stub
	}
	

	public Pais(String nome) {
		super();
		this.nome = nome;
		estados = new ArrayList<Estado>();
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

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}
}
