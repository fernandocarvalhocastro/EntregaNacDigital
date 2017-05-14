package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.EstadoDAO;
import br.com.fiap.natura.entity.Estado;

public class EstadoDAOImpl extends GenericDAOImpl<Estado, Integer> implements EstadoDAO{

	public EstadoDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
