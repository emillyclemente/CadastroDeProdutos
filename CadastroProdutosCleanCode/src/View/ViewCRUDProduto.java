package View;

import java.io.BufferedReader;
import java.io.IOException;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ViewCRUDProduto {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException { //Método para as opções do menu do programa

		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Listar Produtos");
		System.out.println("3 - Deletar Produto");
		System.out.println("4 - Editar Produto");
		System.out.println("5 - Sair");

		return Integer.parseInt(reader.readLine());	
	}

	public static String[] ViewMenuSalvarProduto(BufferedReader reader) throws IOException { //Método para salvar os atributos dos produtos em um vetor
		String[] menuProduto = {"Nome do Produto", "Categoria", "Marca", "Preço"};
		
		String[] dadosProduto = {"","","",""};
		
		for(int i=0; i < dadosProduto.length; i++) { //length é usado quando não sabem a quantidade de informação, ele conta 
			System.out.println(menuProduto[i]);
			dadosProduto[i] = reader.readLine();
		}
		
		return dadosProduto;
	}
	
	public static int ViewMenuListaIndexada (String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException { 
		//Método para carregar a lista e atribuir um indice a cada posição para que o usuário consiga escolher qual posição deseja alterar ou deletar
		
		for(int i=0; i<ListaDeProdutos.getInstance().size(); i++) 
			System.out.println(i+" - "+ ListaDeProdutos.getInstance().get(i));
		
		System.out.println();
		System.out.println("Escolha o indice do produto que deseja " + editar_deletar);
		
		return Integer.parseInt(reader.readLine());

	}
	
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException { // Método para alterar o atributo escolhido pelo usuário
		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar: ");
		System.out.println("1 - Nome do Produto");
		System.out.println("2 - Categoria");
		System.out.println("3 - Marca");
		System.out.println("4 - Preço");

		dadosEditados[0] = reader.readLine(); 
		System.out.println("Escreva o novo valor do atributo: ");
		dadosEditados[1] = reader.readLine();
		
		return dadosEditados;
	}
	
	public static void ViewListaDeProdutosEditada() { //Método para atualizar a lista e mostra-la de forma organizada incluindo alterações que possam ser feitas
		
		for(Produto a: ListaDeProdutos.getInstance()) {
			System.out.println("-------------Produto-------------");
			System.out.println("Nome: " + a.getNome());
			System.out.println("Categoria: " + a.getCategoria());
			System.out.println("Marca: " + a.getMarca().getNomeMarca());
			System.out.println("Preço: " + a.getMarca().getPreco());
			System.out.println("---------------------------------");
			
		}
	}
	
	public static void ViewMsgFinal(int op) { //Método de mensagens para aparecerem no final da realização de cada escolha do menu
		String[] msgFinal = {"Produto salvo com sucesso!!",
							 "Produto deletado com sucesso!!",
							 "Produto editado com sucesso!!",
							 "Fim do Programa!!"};
		System.out.println(msgFinal[op]);
	}

}
