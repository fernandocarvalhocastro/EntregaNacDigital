package br.com.fiap.natura.dao;

import br.com.fiap.natura.entity.Usuario;

public interface UsuarioDAO extends GenericDAO<Usuario, Integer>{

	Usuario autenticarUsuarioLocal(Usuario usuario);
}
