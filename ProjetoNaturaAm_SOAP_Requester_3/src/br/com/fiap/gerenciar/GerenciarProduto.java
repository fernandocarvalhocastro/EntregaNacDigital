package br.com.fiap.gerenciar;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.ProdutoBOStub;
import br.com.fiap.bo.ProdutoBOStub.Atualizar;
import br.com.fiap.bo.ProdutoBOStub.BuscarPorId;
import br.com.fiap.bo.ProdutoBOStub.BuscarPorIdResponse;
import br.com.fiap.bo.ProdutoBOStub.Cadastrar;
import br.com.fiap.bo.ProdutoBOStub.Deletar;
import br.com.fiap.bo.ProdutoBOStub.Listar;
import br.com.fiap.bo.ProdutoBOStub.ListarResponse;
import br.com.fiap.bo.ProdutoBOStub.Produto;

@ManagedBean
public class GerenciarProduto {

	private Produto produto;

	private ProdutoBOStub stub;

	@PostConstruct
	public void init() {
		produto = new Produto();
		try {
			stub = new ProdutoBOStub();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Cadastrar() {
		FacesMessage msg;
		try {
			stub = new ProdutoBOStub();
			
				Cadastrar cadastrar = new Cadastrar();
				cadastrar.setP(produto);
				stub.cadastrar(cadastrar);
				msg = new FacesMessage("Cadastrado com sucesso!");
				msg.setSeverity(FacesMessage.SEVERITY_INFO);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("ERRO");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("ERRO");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	public void buscar() {
		FacesMessage msg;
		try {
			stub = new ProdutoBOStub();
			BuscarPorId busca = new BuscarPorId();
			busca.setId(produto.getId());
			BuscarPorIdResponse p = stub.buscarPorId(busca);
			produto = p.get_return();
			msg = new FacesMessage("Buscado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("ERRO");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			msg = new FacesMessage("ERRO");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}
		FacesContext.getCurrentInstance().addMessage(null, msg);

	}

	public List<Produto> listar() {
		try {
			stub = new ProdutoBOStub();
			Listar lista = new Listar();
			ListarResponse retorna = stub.listar(lista);

			return Arrays.asList(retorna.get_return());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public ProdutoBOStub getStub() {
		return stub;
	}

	public void setStub(ProdutoBOStub stub) {
		this.stub = stub;
	}

}
