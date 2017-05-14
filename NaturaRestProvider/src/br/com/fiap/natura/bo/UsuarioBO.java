package br.com.fiap.natura.bo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.xml.bind.DataBindingException;

import br.com.fiap.natura.dao.UsuarioDAO;
import br.com.fiap.natura.dao.impl.UsuarioDAOImpl;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.exceptions.IdNotFoundException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class UsuarioBO {

	/**
	 * 
	 * @param usuario
	 * @throws CommitException
	 * 
	 * Cadastra um usuário local de software
	 */
	public void cadastrar(Usuario usuario) throws CommitException{
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		
		try {
			dao.inserir(usuario);
			dao.salvar();
		} catch (CommitException e) {
			e.printStackTrace();
			throw new CommitException(e);
		}finally{
			em.close();
		}
	}
	
	/**
	 * 
	 * @return lista de usuário
	 * 
	 * Lista todos usuários cadastrados no banco de dados(Consultores e clientes)
	 * @throws Exception 
	 */
	public List<Usuario> listar() throws Exception{
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		try{
			UsuarioDAO dao = new UsuarioDAOImpl(em);
			return dao.listar(); 
		}catch(Exception e){
			e.printStackTrace();
			throw new Exception();
		}finally {
			em.close();
		}
	}
	
	/**
	 * 
	 * @param usuario
	 * @return usuario
	 * @throws Exception
	 * 
	 * Autentica usuário local de software. Caso o usuario exista, retorne os dados do usuário 
	 */
	public Usuario autenticarUsuarioLocal(Usuario usuario) throws NoResultException{
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		try{
			UsuarioDAO dao  = new UsuarioDAOImpl(em);
			return dao.autenticarUsuarioLocal(usuario);
		}catch(NoResultException e){
			e.printStackTrace();
			throw new NoResultException(e.getMessage());
		}finally{
			em.close();
		}
	}
	
	public void atualizar( Usuario usuario){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		dao.atualizar(usuario);
		try {
			dao.salvar();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void excluir(int id){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		try {
			dao.remover(id);
			dao.salvar();
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Usuario consultar(int id){
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		UsuarioDAO dao = new UsuarioDAOImpl(em);
		return dao.buscar(id);
	}
}
