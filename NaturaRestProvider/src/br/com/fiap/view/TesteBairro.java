package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.BairroDAO;
import br.com.fiap.natura.dao.impl.BairroDAOImpl;
import br.com.fiap.natura.entity.Bairro;
import br.com.fiap.natura.entity.Cidade;
import br.com.fiap.natura.entity.Estado;
import br.com.fiap.natura.entity.Pais;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteBairro {
	public static void main(String[] args) {
		
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		BairroDAO dao = new BairroDAOImpl(em);
		
		Bairro bairro = new Bairro();
		bairro.setNome("Vila Mariana");
		bairro.setCidade(new Cidade("São Paulo", new Estado("SP", new Pais("Brasil")),null));
		
		dao.inserir(bairro);
		try {
			dao.salvar();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}
}
