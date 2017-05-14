package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.LogradouroDAO;
import br.com.fiap.natura.dao.impl.LogradouroDAOImpl;
import br.com.fiap.natura.entity.Logradouro;
import br.com.fiap.natura.entity.TipoLogradouro;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteLogradouro {
	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		LogradouroDAO dao = new LogradouroDAOImpl(em);
		
		Logradouro log = new Logradouro();
		TipoLogradouro tpLog = new TipoLogradouro();
		tpLog.setDescricao("Rua");
		log.setCep("07190060");
		log.setLogradouro("RuaCélia Domingues Faustino");
		log.setTipoLogradouro(tpLog);
		
		dao.inserir(log);
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
