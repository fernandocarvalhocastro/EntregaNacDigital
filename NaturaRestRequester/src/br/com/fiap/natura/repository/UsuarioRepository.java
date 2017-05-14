package br.com.fiap.natura.repository;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.core.MediaType;
import javax.xml.ws.WebServiceException;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

import br.com.fiap.natura.entity.Usuario;

public class UsuarioRepository {
	
	private static String URL = "http://localhost:8081/ProjetoNatura-Challenge/rest/usuario/";
	
	public void cadastrar(Usuario usuario){
		Client client = Client.create();
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).post(ClientResponse.class, usuario);
		if(response.getStatus()!=201){
			throw new WebServiceException("HTTP Error: " + response.getStatus());
		}
	}
	
	public void atualizar(Usuario usuario){
		Client client = Client.create();
		WebResource resource = client.resource(URL + usuario.getCodigo());
		ClientResponse response = resource.type(MediaType.APPLICATION_JSON).put(ClientResponse.class, usuario);
		if(response.getStatus()!=200){
			throw new WebServiceException("HTTP Error: " + response.getStatus());
		}
	}
	
	public Usuario buscar(int codigo){
		Client client = Client.create();
		WebResource resource = client.resource(URL + codigo);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new WebServiceException("HTTP Error: " + response.getStatus());
		}
		return response.getEntity(Usuario.class);
	}
	
	public List<Usuario> listar(){
		Client client = Client.create();
		WebResource resource = client.resource(URL);
		ClientResponse response = resource.accept(MediaType.APPLICATION_JSON).get(ClientResponse.class);
		if(response.getStatus()!=200){
			throw new WebServiceException("HTTP Error: " + response.getStatus());
		}
		  Usuario[] usuarios = response.getEntity(Usuario[].class);
		  return Arrays.asList(usuarios);
	}
	
	public void remover(int codigo){
		Client client = Client.create();
		WebResource resource = client.resource(URL + codigo);
		ClientResponse response = resource.delete(ClientResponse.class);
		if(response.getStatus()!=204){
			throw new WebServiceException("HTTP Error: " + response.getStatus());
		}
	}
}
