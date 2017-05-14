package br.com.fiap.bo;

import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.dao.impl.ProdutoDAOImpl;
import br.com.fiap.entity.Produto;
import br.com.fiap.exception.DBException;
import br.com.fiap.exception.IdNotFoundException;
import br.com.fiap.factory.EntityManagerFactorySingleton;

public class ProdutoBO {

	public void Atualizar(Produto p){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		dao.alterar(p);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	public void Cadastrar(Produto p){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		dao.cadastrar(p);
		try {
			dao.salvar();
		} catch (DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void Deletar(int id){
		EntityManager em =EntityManagerFactorySingleton.getInstance().createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		try {
			dao.remover(id);
			dao.salvar();
		} catch (IdNotFoundException | DBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Produto buscarPorId(int id){
		EntityManager em =EntityManagerFactorySingleton.getInstance().createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		return dao.pesquisar(id);
	}
	
	public List<Produto> listar(){
		EntityManager em =EntityManagerFactorySingleton.getInstance().createEntityManager();
		ProdutoDAO dao = new ProdutoDAOImpl(em);
		return dao.listar();
	}
}
