package br.com.fiap.view;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.CidadeDAO;
import br.com.fiap.natura.dao.impl.CidadeDAOImpl;
import br.com.fiap.natura.entity.Cidade;
import br.com.fiap.natura.entity.Estado;
import br.com.fiap.natura.entity.Pais;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteCidade {

	public static void main(String[] args) {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		CidadeDAO dao = new CidadeDAOImpl(em);
		
		Cidade cidade = new Cidade();
		cidade.setNome("Guarulhos");
		cidade.setEstado(new Estado("São Paulo", new Pais("Brasil")));
		
		dao.inserir(cidade);
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
