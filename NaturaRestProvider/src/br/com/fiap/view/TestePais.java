package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.PaisDAO;
import br.com.fiap.natura.dao.impl.PaisDAOImpl;
import br.com.fiap.natura.entity.Estado;
import br.com.fiap.natura.entity.Pais;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TestePais {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		PaisDAO dao = new PaisDAOImpl(em);
		
		Pais pais = new Pais();
		pais.setNome("Brasil");
		
		pais.adicionarEstado(new Estado("São Paulo"));
		pais.adicionarEstado(new Estado("Rio de Janeiro"));
		
		dao.inserir(pais);
		
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
