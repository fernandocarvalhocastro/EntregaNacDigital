package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.EnderecoDAO;
import br.com.fiap.natura.entity.Endereco;
import br.com.fiap.natura.entity.EnderecoPK;

public class EnderecoDAOImpl extends GenericDAOImpl<Endereco, EnderecoPK> implements EnderecoDAO{

	public EnderecoDAOImpl(EntityManager em) {
		super(em);
	}

}
