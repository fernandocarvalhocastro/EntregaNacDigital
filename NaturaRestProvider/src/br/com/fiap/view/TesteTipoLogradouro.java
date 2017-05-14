package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.TipoLogradouroDAO;
import br.com.fiap.natura.dao.impl.TipoLogradouroDAOImpl;
import br.com.fiap.natura.entity.TipoLogradouro;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteTipoLogradouro {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		TipoLogradouroDAO dao = new TipoLogradouroDAOImpl(em);
		
		TipoLogradouro tipo = new TipoLogradouro();
		tipo.setDescricao("Rua");
		dao.inserir(tipo);
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
