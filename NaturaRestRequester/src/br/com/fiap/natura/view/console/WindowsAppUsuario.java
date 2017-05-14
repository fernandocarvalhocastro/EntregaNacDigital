package br.com.fiap.natura.view.console;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import br.com.fiap.natura.entity.TipoLogin;
import br.com.fiap.natura.entity.TipoUsuario;
import br.com.fiap.natura.entity.Usuario;
import br.com.fiap.natura.repository.UsuarioRepository;

import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.List;
import java.util.*;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class WindowsAppUsuario {

	private JFrame frame;
	private JPasswordField txtSenha;
	private JTextField txtLogin;
	private JTextField txtCodigo;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private final ButtonGroup buttonGroup_2 = new ButtonGroup();
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowsAppUsuario window = new WindowsAppUsuario();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WindowsAppUsuario() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 253, 486);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(10, 71, 46, 14);
		frame.getContentPane().add(lblSenha);
		
		JLabel lblLogin = new JLabel("Login:");
		lblLogin.setBounds(10, 46, 46, 14);
		frame.getContentPane().add(lblLogin);
		
		final JRadioButton rdbtnConsultor = new JRadioButton("Consultor");
		buttonGroup.add(rdbtnConsultor);
		rdbtnConsultor.setBounds(10, 117, 109, 23);
		frame.getContentPane().add(rdbtnConsultor);
		
		final JRadioButton rdbtnCliente = new JRadioButton("Cliente");
		buttonGroup.add(rdbtnCliente);
		rdbtnCliente.setBounds(129, 117, 100, 23);
		frame.getContentPane().add(rdbtnCliente);
		
		JLabel lblTipoDeUsurio = new JLabel("Tipo de usu\u00E1rio:");
		lblTipoDeUsurio.setBounds(10, 96, 120, 14);
		frame.getContentPane().add(lblTipoDeUsurio);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo:");
		lblCdigo.setBounds(9, 18, 46, 14);
		frame.getContentPane().add(lblCdigo);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(55, 67, 135, 20);
		frame.getContentPane().add(txtSenha);
		
		txtLogin = new JTextField();
		txtLogin.setBounds(55, 42, 135, 20);
		frame.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(54, 16, 46, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JLabel lblTipoDeLogin = new JLabel("Tipo de login:");
		lblTipoDeLogin.setBounds(10, 150, 76, 14);
		frame.getContentPane().add(lblTipoDeLogin);
		
		final JRadioButton rdbtnNormal = new JRadioButton("Normal");
		buttonGroup_2.add(rdbtnNormal);
		rdbtnNormal.setBounds(10, 171, 109, 23);
		frame.getContentPane().add(rdbtnNormal);
		
		final JRadioButton rdbtnFacebook = new JRadioButton("Facebook");
		buttonGroup_2.add(rdbtnFacebook);
		rdbtnFacebook.setBounds(129, 171, 109, 23);
		frame.getContentPane().add(rdbtnFacebook);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UsuarioRepository repository = new UsuarioRepository();
					Usuario usuario = new Usuario();
					usuario.setLogin(txtLogin.getText().trim());
					usuario.setSenha(txtSenha.getPassword().toString().trim());
					usuario.setTipoUsuario(rdbtnCliente.isSelected() == true ? TipoUsuario.CLIENTE : TipoUsuario.CONSULTOR);
					usuario.setTipoLogin(rdbtnFacebook.isSelected() == true ? TipoLogin.FACEBOOK : TipoLogin.NORMAL);
					repository.cadastrar(usuario);
					JOptionPane.showMessageDialog(null, "Usu�rio cadastrado com sucesso.");
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Falha ao cadastrar usu�rio - " + erro.getMessage());
				}
				
			}
		});
		btnCadastrar.setBounds(10, 212, 109, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnApagar = new JButton("Apagar");
		btnApagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioRepository repository = new UsuarioRepository();
				try{
					Usuario usuario = repository.buscar(Integer.parseInt(txtCodigo.getText().trim()));
					if(usuario==null){
						JOptionPane.showMessageDialog(null, "Usu�rio n�o existe.");
					}
					repository.remover(Integer.parseInt(txtCodigo.getText().trim()));
					JOptionPane.showMessageDialog(null, "Usu�rio apagado com sucesso.");
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Falha ao apagar usu�rio - " + erro.getMessage());
				}
				
			}
		});
		btnApagar.setBounds(127, 212, 102, 23);
		frame.getContentPane().add(btnApagar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					UsuarioRepository repository = new UsuarioRepository();
					Usuario usuario = repository.buscar(Integer.parseInt(txtCodigo.getText().trim()));
					txtLogin.setText(usuario.getLogin());
					if(usuario.getTipoLogin() == TipoLogin.NORMAL){
						rdbtnNormal.setSelected(true);
						rdbtnFacebook.setSelected(false);
					}else{
						rdbtnNormal.setSelected(false);
						rdbtnFacebook.setSelected(true);
					}
					if(usuario.getTipoUsuario() == TipoUsuario.CLIENTE){
						rdbtnCliente.setSelected(true);
						rdbtnConsultor.setSelected(false);
					}else{
						rdbtnCliente.setSelected(false);
						rdbtnConsultor.setSelected(true);
					}
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null,erro.getMessage());
				}
			}
		});
		btnBuscar.setBounds(110, 14, 80, 23);
		frame.getContentPane().add(btnBuscar);
		
		final List list = new List();
		list.setBounds(8, 312, 221, 126);
		frame.getContentPane().add(list);
		
		JLabel lblUsurios = new JLabel("Usu\u00E1rios:");
		lblUsurios.setBounds(8, 292, 46, 14);
		frame.getContentPane().add(lblUsurios);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				list.removeAll();
				UsuarioRepository repositorio = new UsuarioRepository();
				try{
					java.util.List<Usuario> lista = repositorio.listar();
					for(Usuario u : lista){
						list.add(u.getCodigo() + " - " + u.getLogin());
					}
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, "Falha ao listar usu�rios - " + erro.getMessage());
				}
				
			}
		});
		btnListar.setBounds(129, 246, 100, 23);
		frame.getContentPane().add(btnListar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UsuarioRepository repository = new UsuarioRepository();
				Usuario usuario = new Usuario();
				try{
					usuario.setCodigo(Integer.parseInt(txtCodigo.getText().trim()));
					usuario.setLogin(txtLogin.getText().trim());
					usuario.setSenha(txtSenha.getPassword().toString().trim());
					usuario.setTipoUsuario(rdbtnCliente.isSelected() == true ? TipoUsuario.CLIENTE : TipoUsuario.CONSULTOR);
					usuario.setTipoLogin(rdbtnFacebook.isSelected() == true ? TipoLogin.FACEBOOK : TipoLogin.NORMAL);
					repository.atualizar(usuario);
					JOptionPane.showMessageDialog(null, "Usu�rio atualizado com sucesso");
				}catch(Exception erro){
					JOptionPane.showMessageDialog(null, erro.getMessage());
				}
				
			}
		});
		btnAtualizar.setBounds(11, 246, 108, 23);
		frame.getContentPane().add(btnAtualizar);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}