package br.com.fiap.natura.entity;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Fernando C. Castro
 * @since 27/04/2017
 * 
 * Classe genérica de usuário de software. Um usuário pode ser uma consultora ou um cliente.
 */
@XmlRootElement
@Entity
@Table(name="T_NAT_USUARIO")
@SequenceGenerator(name="seqUsuario", sequenceName="SQ_USUARIO", allocationSize=1)
public class Usuario {

	@Id
	@GeneratedValue(generator="seqUsuario", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_usuario")
	private int codigo;
	
	@Column(name="ds_login", nullable=false, length=50)
	private String login;
	
	@Column(name="ds_senha", nullable=false, length=100)
	private String senha;
	
	@Column(name="cd_facebook")
	private int codigoFacebook;
	
	@Enumerated(EnumType.STRING)
	private TipoUsuario tipoUsuario;
	
	@Enumerated(EnumType.STRING)
	private TipoLogin tipoLogin;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(String login, String senha, int codigoFacebook) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		super();
		this.login = login;
		this.senha = criptografar(senha);
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

	public void setSenha(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		this.senha = criptografar(senha);
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

	public String criptografar(String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{	   
        MessageDigest algorithm = MessageDigest.getInstance("MD5");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
        
        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        return hexString.toString();    
	}
}
