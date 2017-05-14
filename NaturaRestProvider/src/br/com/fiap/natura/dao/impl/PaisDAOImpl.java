package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.PaisDAO;
import br.com.fiap.natura.entity.Pais;

public class PaisDAOImpl extends GenericDAOImpl<Pais, Integer> implements PaisDAO{

	public PaisDAOImpl(EntityManager em) {
		super(em);
	}

}
