package View;

import java.io.BufferedReader;
import java.io.IOException;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ViewCRUDProduto {

	public static int ViewMenuPrincipal(BufferedReader reader) throws NumberFormatException, IOException { //M�todo para as op��es do menu do programa

		System.out.println("1 - Cadastrar Produto");
		System.out.println("2 - Listar Produtos");
		System.out.println("3 - Deletar Produto");
		System.out.println("4 - Editar Produto");
		System.out.println("5 - Sair");

		return Integer.parseInt(reader.readLine());	
	}

	public static String[] ViewMenuSalvarProduto(BufferedReader reader) throws IOException { //M�todo para salvar os atributos dos produtos em um vetor
		String[] menuProduto = {"Nome do Produto", "Categoria", "Marca", "Pre�o"};
		
		String[] dadosProduto = {"","","",""};
		
		for(int i=0; i < dadosProduto.length; i++) { //length � usado quando n�o sabem a quantidade de informa��o, ele conta 
			System.out.println(menuProduto[i]);
			dadosProduto[i] = reader.readLine();
		}
		
		return dadosProduto;
	}
	
	public static int ViewMenuListaIndexada (String editar_deletar, BufferedReader reader) throws NumberFormatException, IOException { 
		//M�todo para carregar a lista e atribuir um indice a cada posi��o para que o usu�rio consiga escolher qual posi��o deseja alterar ou deletar
		
		for(int i=0; i<ListaDeProdutos.getInstance().size(); i++) 
			System.out.println(i+" - "+ ListaDeProdutos.getInstance().get(i));
		
		System.out.println();
		System.out.println("Escolha o indice do produto que deseja " + editar_deletar);
		
		return Integer.parseInt(reader.readLine());

	}
	
	public static String[] ViewOpcaoEdicao(BufferedReader reader) throws IOException { // M�todo para alterar o atributo escolhido pelo usu�rio
		String[] dadosEditados = {"",""};
		
		System.out.println("Escolha o atributo que deseja alterar: ");
		System.out.println("1 - Nome do Produto");
		System.out.println("2 - Categoria");
		System.out.println("3 - Marca");
		System.out.println("4 - Pre�o");

		dadosEditados[0] = reader.readLine(); 
		System.out.println("Escreva o novo valor do atributo: ");
		dadosEditados[1] = reader.readLine();
		
		return dadosEditados;
	}
	
	public static void ViewListaDeProdutosEditada() { //M�todo para atualizar a lista e mostra-la de forma organizada incluindo altera��es que possam ser feitas
		
		for(Produto a: ListaDeProdutos.getInstance()) {
			System.out.println("-------------Produto-------------");
			System.out.println("Nome: " + a.getNome());
			System.out.println("Categoria: " + a.getCategoria());
			System.out.println("Marca: " + a.getMarca().getNomeMarca());
			System.out.println("Pre�o: " + a.getMarca().getPreco());
			System.out.println("---------------------------------");
			
		}
	}
	
	public static void ViewMsgFinal(int op) { //M�todo de mensagens para aparecerem no final da realiza��o de cada escolha do menu
		String[] msgFinal = {"Produto salvo com sucesso!!",
							 "Produto deletado com sucesso!!",
							 "Produto editado com sucesso!!",
							 "Fim do Programa!!"};
		System.out.println(msgFinal[op]);
	}

}
