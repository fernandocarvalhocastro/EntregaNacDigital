package br.com.fiap.natura.bean;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceException;

import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.repository.UsuarioRepository;

@ManagedBean
public class BuscaUsuarioBean {

	private Usuario usuario;
	
	private UsuarioRepository usuarioRepository;

	@PostConstruct
	private void Inicializar() {
		usuario = new Usuario();
		usuarioRepository = new UsuarioRepository();
	}

	public void buscar() {

		FacesMessage msg = null;

		try {

			this.usuario = usuarioRepository.buscar(usuario.getCodigo());

		} catch (WebServiceException e) {

			e.printStackTrace();
			msg = new FacesMessage("Erro ao buscar usuario");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}

	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
