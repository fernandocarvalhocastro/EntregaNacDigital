package br.com.fiap.natura.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.xml.ws.WebServiceException;

import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.repository.UsuarioRepository;

@ManagedBean
public class ListaUsuarioBean {

	private List<Usuario> usuarios;

	private UsuarioRepository rep;

	@PostConstruct
	private void init() {
		rep = new UsuarioRepository();
		try {
			usuarios = new ArrayList<Usuario>();
		} catch (WebServiceException e) {
			e.printStackTrace();
		}
	}

	public List<Usuario> listar() {
		return rep.listar();
	}

	public List<Usuario> getLista() {
		return usuarios;
	}

	public void setLista(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}