package br.com.fiap.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_AM_NATURA_PRODUTO")
@SequenceGenerator(allocationSize=1, name="sq_produto", sequenceName="SQ_T_AM_PRODUTO_NAT")
public class Produto {

	@Id
	@Column(name="cd_produto")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="sq_produto")
	private int id;
	
	@Column(name="ds_produto", nullable=false)
	private String descricao;
	
	@Column(name="nr_quantidade")
	private int quantidade;
	
	@Column(name="vl_unitario")
	private double valorUnitario;
	
	
	
	public Produto() {
		super();
	}
	public Produto(int id, String descricao, int quantidade, double valorUnitario) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.quantidade = quantidade;
		this.valorUnitario = valorUnitario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public double getValorUnitario() {
		return valorUnitario;
	}
	public void setValorUnitario(double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	
	
}
