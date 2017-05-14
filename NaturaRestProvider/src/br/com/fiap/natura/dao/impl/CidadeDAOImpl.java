package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.CidadeDAO;
import br.com.fiap.natura.entity.Cidade;

public class CidadeDAOImpl extends GenericDAOImpl<Cidade, Integer> implements CidadeDAO{

	public CidadeDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
