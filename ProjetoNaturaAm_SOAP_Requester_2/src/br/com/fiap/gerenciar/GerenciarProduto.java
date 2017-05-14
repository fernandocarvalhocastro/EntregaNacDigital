package br.com.fiap.gerenciar;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.List;

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

public class GerenciarProduto {

	public void Cadastrar(Produto p){
		try {
			ProdutoBOStub stub = new ProdutoBOStub();
		
			Cadastrar cadastrar = new Cadastrar();
			cadastrar.setP(p);
			stub.cadastrar(cadastrar);
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Excluir(int id){
		
		try {
			ProdutoBOStub stub = new ProdutoBOStub();
			Deletar del = new Deletar();
			del.setId(id);
			stub.deletar(del);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Alterar(Produto p){
		try {
			ProdutoBOStub stub = new ProdutoBOStub();
			Atualizar atualizar = new Atualizar();
			atualizar.setP(p);
			stub.atualizar(atualizar);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Produto buscar(int id){
		try {
			ProdutoBOStub stub = new ProdutoBOStub();
			BuscarPorId busca = new BuscarPorId();
			busca.setId(id);
			BuscarPorIdResponse p = stub.buscarPorId(busca);
			return p.get_return();
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<Produto> listar(){
		try {
			ProdutoBOStub stub = new ProdutoBOStub();
			Listar lista = new Listar();
			ListarResponse retorna = stub.listar(lista);
			
			return Arrays.asList(retorna.get_return());
		} catch ( RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
