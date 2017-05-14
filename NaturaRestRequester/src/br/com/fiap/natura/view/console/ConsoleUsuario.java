package br.com.fiap.natura.view.console;

import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import br.com.fiap.natura.entity.TipoLogin;
import br.com.fiap.natura.entity.TipoUsuario;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.repository.UsuarioRepository;

public class ConsoleUsuario {
	
	public static void main(String[] args) {

		Scanner leitor = new Scanner(System.in);
		UsuarioRepository  usuarioRepository = new UsuarioRepository();
		
		while (true) {
			menu();
			try {
				int valorMenu = leitor.nextInt();
				switch (valorMenu) {
				case 1: {
					Usuario usuario = new Usuario();
					System.out.println("Selecione o tipo de login: ");
					System.out.println("0 - Normal");
					System.out.println("1 - Facebook");
					usuario.setTipoLogin(TipoLogin.values()[leitor.nextInt()]);
					System.out.println("Selecione o tipo de usuário: ");
					System.out.println("0 - Consultor");
					System.out.println("1 - Cliente");
					usuario.setTipoUsuario(TipoUsuario.values()[leitor.nextInt()]);
					System.out.println("Entre com o login: ");
					usuario.setLogin(leitor.next() + leitor.nextLine());
					System.out.println("Entre com a senha: ");
					usuario.setSenha(leitor.next() + leitor.nextLine());
					usuarioRepository.cadastrar(usuario);
					System.out.println("Usuário cadastrado com sucesso.");
					break;
				}
				case 2: {
					List<Usuario> listar = usuarioRepository.listar();
					for(Usuario u : listar){
						System.out.println("Codigo: " + u.getCodigo());
						System.out.println("Login: " + u.getLogin());
						System.out.println("Senha: " + u.getSenha());
						System.out.println("Tipo Login: " + u.getTipoLogin());
						System.out.println("Tipo Usuário: " + u.getTipoUsuario() +"\n");
					}
					break;
				}
				case 3: {
					System.out.println("Digite o código do usuário: ");
					int codigo = leitor.nextInt();
					Usuario u = usuarioRepository.buscar(codigo);
					System.out.println("Codigo: " + u.getCodigo());
					System.out.println("Login: " + u.getLogin());
					System.out.println("Senha: " + u.getSenha());
					System.out.println("Tipo Login: " + u.getTipoLogin());
					System.out.println("Tipo Usuário: " + u.getTipoUsuario() +"\n");
					break;
				}
				case 4: {
					System.out.println("Digite o código do usuário para remover: ");
					int codigo = leitor.nextInt();
					Usuario u = usuarioRepository.buscar(codigo);
					if(u!=null){
						usuarioRepository.remover(codigo);
						System.out.println("Usuário " + u.getLogin() + " removido com sucesso");
					}else{
						System.out.println("Usuário não existe.");
					}	
					break;
				}
				case 5: {
					System.out.println("Digite o código do usuário para atualizar: ");
					int codigo = leitor.nextInt();
					Usuario u = usuarioRepository.buscar(codigo);
					if(u!=null){
					Usuario usuario = new Usuario();
					usuario.setCodigo(codigo);
					System.out.println("Selecione o tipo de login: ");
					System.out.println("0 - Normal");
					System.out.println("1 - Facebook");
					usuario.setTipoLogin(TipoLogin.values()[leitor.nextInt()]);
					System.out.println("Selecione o tipo de usuário: ");
					System.out.println("0 - Consultor");
					System.out.println("1 - Cliente");
					usuario.setTipoUsuario(TipoUsuario.values()[leitor.nextInt()]);
					System.out.println("Entre com o login: ");
					usuario.setLogin(leitor.next() + leitor.nextLine());
					System.out.println("Entre com a senha: ");
					usuario.setSenha(leitor.next() + leitor.nextLine());
					usuarioRepository.atualizar(usuario);
					System.out.println("Usuário atualizado com sucesso.");
					}
					break;
				}
				case 6: {
					leitor.close();
					System.exit(0);
					break;
				}
				default: {
					System.err.println("Entrada Inválida!");
				}
				}
			} catch (Exception e) {
				System.err.println("Entrada Inválida!" + e.getMessage());
				e.printStackTrace();
			}
		}
	}

	private static void menu() {
		System.out.println("************** NATURA - Cadastro de Usuário **************");
		System.out.println("*                                                        *");
		System.out.println("* Selecione uma das operações abaixo:                    *");
		System.out.println("* 1 - Cadastro                                           *");
		System.out.println("* 2 - Listar                                             *");
		System.out.println("* 3 - Buscar                                             *");
		System.out.println("* 4 - Remover                                            *");
		System.out.println("* 5 - Atualizar                                          *");
		System.out.println("* 6 - Sair                                               *");
		System.out.println("*                                                        *");
		System.out.println("**********************************************************");
	}
}
