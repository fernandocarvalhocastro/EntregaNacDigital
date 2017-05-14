package br.com.fiap.natura.bean;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.xml.ws.WebServiceException;

import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.repository.UsuarioRepository;

@ManagedBean
public class CadastraUsuarioBean {

	private Usuario usuario;
	private UsuarioRepository usuarioRepository;

	@PostConstruct
	private void Inicializar() {
		usuario = new Usuario();
		usuarioRepository = new UsuarioRepository();
	}

	public void cadastrar() {
		FacesMessage msg;

		try {

			usuarioRepository.cadastrar(usuario);
			msg = new FacesMessage("cadastrado com sucesso!");
			msg.setSeverity(FacesMessage.SEVERITY_INFO);

		} catch (WebServiceException e) {

			e.printStackTrace();
			msg = new FacesMessage("Erro ao cadastrar");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		}

		FacesContext.getCurrentInstance().addMessage(null, msg);

		FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario Usuario) {
		this.usuario = Usuario;
	}

}
