package br.com.fiap.resource;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.natura.bo.UsuarioBO;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.exceptions.CommitException;

@Path("/usuario")
public class UsuarioResource {

	UsuarioBO bo;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Usuario> listar() throws Exception {
		return new UsuarioBO().listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario buscarPorCodigo(@PathParam("id") int id){
		 bo = new UsuarioBO();
		 return bo.consultar(id);
	}
	
	@GET
	@Path("/{login}/{senha}")
	@Produces(MediaType.APPLICATION_JSON)
	public Usuario autenticarUsuarioLocal(@PathParam("login") String login, @PathParam("senha") String senha) {
		Usuario usuario = new Usuario();
		usuario.setLogin(login);
		try {
			usuario.setSenha(senha);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Usuario user = new UsuarioBO().autenticarUsuarioLocal(usuario);
		if (user != null) {
			return user;
		}
		return null;
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Cadastrar(Usuario usuario, @Context UriInfo uriInfo) {
		bo = new UsuarioBO();
		try {
			bo.cadastrar(usuario);
			UriBuilder builder = uriInfo.getAbsolutePathBuilder();
			builder.path(Integer.toString(usuario.getCodigo()));
			return Response.created(builder.build()).build();
		} catch (CommitException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response Atualizar(Usuario usuario, @PathParam("id") int codigo){
		usuario.setCodigo(codigo);
		bo = new UsuarioBO();
		bo.atualizar(usuario);
		return Response.ok().build();
		
	}
	
	
	@DELETE
	@Path("/{id}")
	public void remover(@PathParam("id") int id){
		 bo = new UsuarioBO();
		bo.excluir(id);
	}
	
}
