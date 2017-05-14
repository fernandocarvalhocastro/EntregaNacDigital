package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.BairroDAO;
import br.com.fiap.natura.entity.Bairro;

public class BairroDAOImpl extends GenericDAOImpl<Bairro, Integer> implements BairroDAO{

	public BairroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
