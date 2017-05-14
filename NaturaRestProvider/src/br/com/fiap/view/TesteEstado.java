package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.EstadoDAO;
import br.com.fiap.natura.dao.impl.EstadoDAOImpl;
import br.com.fiap.natura.dao.impl.PaisDAOImpl;
import br.com.fiap.natura.entity.Estado;
import br.com.fiap.natura.entity.Pais;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteEstado {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EstadoDAO dao = new EstadoDAOImpl(em);
		
		Estado estado = new Estado("Minas Gerais",new Pais("Brasil"));
		dao.inserir(estado);
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
