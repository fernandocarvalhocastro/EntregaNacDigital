package br.com.fiap.view;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.persistence.EntityManager;

import br.com.fiap.natura.dao.EnderecoDAO;
import br.com.fiap.natura.dao.impl.EnderecoDAOImpl;
import br.com.fiap.natura.entity.Bairro;
import br.com.fiap.natura.entity.Endereco;
import br.com.fiap.natura.entity.Logradouro;
import br.com.fiap.natura.entity.TipoLogradouro;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.exceptions.CommitException;
import br.com.fiap.natura.singleton.EntityManagerFactorySingleton;

public class TesteEndereco {
	public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		EntityManager em = EntityManagerFactorySingleton.getInstance().createEntityManager();
		EnderecoDAO dao = new EnderecoDAOImpl(em);
		
		Endereco end = new Endereco();
		end.setComplemento("BL 06 Apto B-33");
		end.setNumero(89);
		end.setUsuario(new Usuario ("fernando","123456",0));
		Logradouro log = new Logradouro("07190060","R. Célia Domingues", null,null,null);
		log.setTipoLogradouro(new TipoLogradouro("Rua", null));
		end.setLogradouro(log);
		
		dao.inserir(end);
		try {
			dao.salvar();
		} catch (CommitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		em.close();
		System.exit(0);
	}
}
