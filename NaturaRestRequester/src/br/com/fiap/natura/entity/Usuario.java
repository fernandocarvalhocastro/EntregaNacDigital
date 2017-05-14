package br.com.fiap.natura.entity;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;


/**
 * 
 * @author Linked4It
 * @since 27/04/2017
 * 
 *        Classe genrica de usurio de software. Um usurio pode ser uma
 *        consultora ou um cliente.
 */

public class Usuario {

	private int codigo;
	private String login;
	private String senha;
	private int codigoFacebook;
	private TipoUsuario tipoUsuario;
	private TipoLogin tipoLogin;

	public Usuario() {
		super();
	}

	public Usuario(String login, String senha, int codigoFacebook){
		super();
		this.login = login;
		this.senha = senha;
		this.codigoFacebook = codigoFacebook;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getCodigoFacebook() {
		return codigoFacebook;
	}

	public void setCodigoFacebook(int codigoFacebook) {
		this.codigoFacebook = codigoFacebook;
	}

	public TipoUsuario getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	public TipoLogin getTipoLogin() {
		return tipoLogin;
	}

	public void setTipoLogin(TipoLogin tipoLogin) {
		this.tipoLogin = tipoLogin;
	}

}
