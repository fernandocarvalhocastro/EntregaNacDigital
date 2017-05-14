package br.com.fiap.natura.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.natura.dao.UsuarioDAO;
import br.com.fiap.natura.entity.Usuario;


public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO{

	public UsuarioDAOImpl(EntityManager em) {
		super(em);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Usuario autenticarUsuarioLocal(Usuario usuario) throws NoResultException{
		TypedQuery<Usuario> query = em.createQuery("from Usuario u where u.login = :login and u.senha = :senha", Usuario.class);
		query.setParameter("login", usuario.getLogin());
		query.setParameter("senha", usuario.getSenha());
		try{
			Usuario user = query.getSingleResult();
			return user;
		}catch(NoResultException e){
			throw new NoResultException("Usuário ou senha inválido.");
		}
	}
}
