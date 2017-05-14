package br.com.fiap.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.com.fiap.bo.ProdutoBOStub.Produto;
import br.com.fiap.gerenciar.GerenciarProduto;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewProduto {

	private JFrame frame;
	private JTextField txtCodigo;
	private JTextField txtDescricao;
	private JTextField txtQuantidade;
	private JTextField txtValorUnitario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewProduto window = new ViewProduto();
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
	public ViewProduto() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 294, 263);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCdigo = new JLabel("C\u00F3digo");
		lblCdigo.setBounds(34, 26, 46, 14);
		frame.getContentPane().add(lblCdigo);
		
		JLabel lblDescrio = new JLabel("Descri\u00E7\u00E3o");
		lblDescrio.setBounds(34, 51, 101, 14);
		frame.getContentPane().add(lblDescrio);
		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setBounds(34, 76, 79, 14);
		frame.getContentPane().add(lblQuantidade);
		
		JLabel lblValorUnitrio = new JLabel("Valor unit\u00E1rio");
		lblValorUnitrio.setBounds(34, 101, 101, 14);
		frame.getContentPane().add(lblValorUnitrio);
		
		JLabel lblMensagem = new JLabel("");
		lblMensagem.setBounds(10, 199, 258, 14);
		frame.getContentPane().add(lblMensagem);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(139, 23, 98, 20);
		frame.getContentPane().add(txtCodigo);
		txtCodigo.setColumns(10);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(139, 48, 98, 20);
		frame.getContentPane().add(txtDescricao);
		txtDescricao.setColumns(10);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setBounds(139, 73, 98, 20);
		frame.getContentPane().add(txtQuantidade);
		txtQuantidade.setColumns(10);
		
		txtValorUnitario = new JTextField();
		txtValorUnitario.setBounds(139, 98, 98, 20);
		frame.getContentPane().add(txtValorUnitario);
		txtValorUnitario.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GerenciarProduto prod = new GerenciarProduto();
				Produto p = new Produto();
				p.setDescricao(txtDescricao.getText());
				p.setQuantidade(Integer.parseInt(txtQuantidade.getText()));
				p.setValorUnitario(Double.parseDouble(txtValorUnitario.getText()));
				prod.Cadastrar(p);
				lblMensagem.setText(p.getDescricao()+" cadastrado com sucesso!");
				
			}
		});
		btnCadastrar.setBounds(24, 126, 111, 23);
		frame.getContentPane().add(btnCadastrar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				GerenciarProduto prod = new GerenciarProduto();
				Produto p = prod.buscar(Integer.parseInt(txtCodigo.getText()));
				if(p==null){
					JOptionPane.showMessageDialog(null, "Produto não encontrado.");
				}else{
				txtCodigo.setText(String.valueOf(p.getId()));
				txtDescricao.setText(p.getDescricao());
				txtQuantidade.setText(String.valueOf(p.getQuantidade()));
				txtValorUnitario.setText(String.valueOf(p.getValorUnitario()));
				lblMensagem.setText("");
				}
			}
		});
		btnBuscar.setBounds(136, 126, 101, 23);
		frame.getContentPane().add(btnBuscar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(24, 162, 111, 23);
		frame.getContentPane().add(btnSair);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCodigo.setText("");
				txtDescricao.setText("");
				txtQuantidade.setText("");
				txtValorUnitario.setText("");
				
				
			}
		});
		btnLimpar.setBounds(139, 162, 98, 23);
		frame.getContentPane().add(btnLimpar);
	}
}
