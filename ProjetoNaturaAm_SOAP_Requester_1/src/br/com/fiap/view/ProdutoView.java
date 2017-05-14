package br.com.fiap.view;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import org.apache.axis2.AxisFault;

import br.com.fiap.bo.ProdutoBOStub;
import br.com.fiap.bo.ProdutoBOStub.Cadastrar;
import br.com.fiap.bo.ProdutoBOStub.Produto;
import br.com.fiap.gerenciar.GerenciarProduto;

public class ProdutoView {

	public static void main(String[] args) {
		Scanner tec = new Scanner(System.in);
		GerenciarProduto prod;
		Produto p;
		System.out.println("Bem vindo ao gerenciador de Produtos Natura!");

		boolean escolha = false;

		while (escolha != true) {
			System.out.println(
					"\nSelecione uma opção: \n1-Cadastrar \n2-Excluir \n3-Alterar \n4-buscar por ID \n5-Listar \n6-Sair");
			int resp = tec.nextInt();

			switch (resp) {
			case 1:
				p = new Produto();
				System.out.print("Digite a descrição: ");
				p.setDescricao(tec.nextLine() + tec.next());

				System.out.print("Digite a quantidade: ");
				p.setQuantidade(tec.nextInt());

				System.out.print("Digite o valor unitário: ");
				p.setValorUnitario(tec.nextDouble());

				prod = new GerenciarProduto();

				prod.Cadastrar(p);
				System.out.println("Inserido com sucesso!");

				break;
			case 2:
				prod = new GerenciarProduto();
				System.out.print("Digite o ID do produto a ser excluido: ");
				prod.Excluir(tec.nextInt());

				System.out.println("Produto Excluido!");
				break;
			case 3:
				p = new Produto();
				System.out.print("Digite o ID do produto a ser alterado: ");
				p.setId(tec.nextInt());
				
				System.out.print("Digite a descrição: ");
				p.setDescricao(tec.nextLine() + tec.next());

				System.out.print("Digite a quantidade: ");
				p.setQuantidade(tec.nextInt());

				System.out.print("Digite o valor unitário: ");
				p.setValorUnitario(tec.nextDouble());

				prod = new GerenciarProduto();
				
				prod.Alterar(p);
				System.out.println("Atualizado com sucesso!");
				break;

			case 4:
				prod = new GerenciarProduto();
				System.out.print("Selecione o ID do produto a ser buscado: ");
				Produto pt = prod.buscar(tec.nextInt());
				
				System.out.println("INFORMAÇÕES DO PRODUTO ");
				System.out.println("Descrição: " + pt.getDescricao() + "\nQuantidade: " +pt.getQuantidade()+"\nValor Unitário: " + pt.getValorUnitario());
				break;
			case 5:
				System.out.println("LISTA DE PRODUTOS");
				prod = new GerenciarProduto();
				List<Produto> lista = prod.listar();
				
				for (Produto produto : lista) {
						System.out.println();
						System.out.println("ID: "+produto.getId() + "\nDescrição: " + produto.getDescricao() + "\nQuantidade: "+produto.getDescricao()+"\nValor Unitário: " +produto.getValorUnitario());
				}
				break;
			case 6:
				System.out.println("Saindo...");
				System.exit(0);
				break;
			default:
				break;
			}
		}

	}
}
