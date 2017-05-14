package br.com.fiap.view;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;


import br.com.fiap.natura.bo.UsuarioBO;

import br.com.fiap.natura.entity.TipoLogin;
import br.com.fiap.natura.entity.TipoUsuario;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteUsuario {

	public static void main(String[] args) throws Exception {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		Usuario usuario = new Usuario();
		usuario.setLogin("Luizinho");
		usuario.setSenha("123456");
		usuario.setTipoLogin(TipoLogin.FACEBOOK);
		usuario.setTipoUsuario(TipoUsuario.CONSULTOR);

		UsuarioBO bo = new UsuarioBO();

		bo.cadastrar(usuario);
		try {

			System.out.println("CADASTRADO");

			System.out.println("LISTAR");
			List<Usuario> lista = bo.listar();
			for (Usuario u : lista) {
				System.out.println(u.getCodigo() + "-" + u.getLogin());
			}

			System.out.println("AUTENTICAR");
			Usuario user = bo.autenticarUsuarioLocal(new Usuario("Juca", "123456", 0));
			System.out.println("Usuário autenticado com sucesso");

		} catch (NoResultException e) {
			System.out.println(e.getMessage());
		}
		
		
		em.close();
		System.exit(0);
	}

}
