package br.com.fiap.natura.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author Fernando C. Castro
 * @since 29/04/2017
 * 
 * Classe que representa um tipo de logradouro. Ex.: Rua, Avenida, Rodovia, etc.
 */

@Entity
@Table(name="T_NAT_TIPO_LOG")
@SequenceGenerator(name="seqTipoLog", sequenceName="SQ_TIPO_LOG", allocationSize=1)
public class TipoLogradouro {
	
	@Id
	@Column(name="cd_tipo_log")
	private int codigo;
	
	@Column(name="ds_tipo_log",nullable=false,length=50)
	private String descricao;

	@OneToMany(mappedBy="tipoLogradouro",cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
	private List<Logradouro> logradouros = new ArrayList<Logradouro>();
	
	public void adicionarLogradouro(Logradouro logradouro){
		logradouro.setTipoLogradouro(this);
		logradouros.add(logradouro);
		this.setLogradouros(logradouros);
	}
	
	public TipoLogradouro() {
		super();
	}
	

	public TipoLogradouro(String descricao, List<Logradouro> logradouros) {
		super();
		this.descricao = descricao;
		this.logradouros = logradouros;
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

	public List<Logradouro> getLogradouros() {
		return logradouros;
	}

	public void setLogradouros(List<Logradouro> logradouros) {
		this.logradouros = logradouros;
	}

}
