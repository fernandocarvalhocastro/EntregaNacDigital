package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.LogradouroDAO;
import br.com.fiap.natura.entity.Logradouro;

public class LogradouroDAOImpl extends GenericDAOImpl<Logradouro, Integer> implements LogradouroDAO{

	public LogradouroDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

}
