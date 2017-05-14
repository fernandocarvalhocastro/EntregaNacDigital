package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.TipoLogradouroDAO;
import br.com.fiap.natura.entity.TipoLogradouro;

public class TipoLogradouroDAOImpl extends GenericDAOImpl<TipoLogradouro, Integer> implements TipoLogradouroDAO{

	public TipoLogradouroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
