package Aplicação;
//manipulação do objeto

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import Modelos.Marca;
import Modelos.Produto;

public class CRUDProduto {

	public static Produto SalvarProduto(BufferedReader reader) { //Objeto criado sem utilizar o "new", e sim o static.

		Produto produto = new Produto();
		Marca marca = new Marca();

		try {
			System.out.println("Cadastro de Produtos");
			System.out.println(" ");
			System.out.println("Nome: ");
			produto.setNome(reader.readLine());
			System.out.println("Categoria: ");
			produto.setCategoria(reader.readLine());
			System.out.println("Marca: ");
			marca.setNomeMarca(reader.readLine());
			System.out.println("Preço: ");
			marca.setPreco(Float.parseFloat(reader.readLine()));
			System.out.println("");

			produto.setMarca(marca);

			try (BufferedWriter buffer = new BufferedWriter(new FileWriter ("ProdutosCadastrados.txt", true));
					PrintWriter pw = new PrintWriter(buffer)) {
				pw.println(produto);
			}


		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return produto;
	}

	public static List<Produto> ListarProdutosSalvos(int op) {
		List<Produto> listadeProduto = new ArrayList<Produto>();

		String line = "";

		try(BufferedReader reader = new BufferedReader(new FileReader("ProdutosCadastrados.txt")))  {

			while((line = reader.readLine())!= null) {
				Produto produto = new Produto(line);
				listadeProduto.add(produto);

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		if (op==0) {
			
		
		for (Produto a: listadeProduto)
			System.out.println(a);
		}

		return listadeProduto;

	}
	
	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException{
		List<Produto> listaDeproduto = ListarProdutosSalvos(1);

		for(int i=0; i<listaDeproduto.size(); i++)
			System.out.println(i+" - " + listaDeproduto.get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do produto que deseja deletar");
		int indice = Integer.parseInt(reader.readLine());

		listaDeproduto.remove(indice);

		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("ProdutosCadastrados.txt"));
				PrintWriter pw = new PrintWriter(buffer)){
			for (Produto a:listaDeproduto)
				pw.println(a);
		}
	}
	
	public static void EditarProduto (BufferedReader reader) throws NumberFormatException, IOException{
		List<Produto> listaDeproduto = ListarProdutosSalvos(1);

		for(int i=0;i<listaDeproduto.size();i++)
			System.out.println(i+" - " + listaDeproduto.get(i));

		System.out.println();
		System.out.println("Dentre a lista acima, escolha o indice do produto que deseja editar");
		int indice = Integer.parseInt(reader.readLine());

		Produto produto = listaDeproduto.get(indice);
		Marca marca = produto.getMarca();

		System.out.println("Escolha o atributo que deseja alterar");
		System.out.println("1-Nome");
		System.out.println("2-Categoria");
		System.out.println("3-Marca");
		System.out.println("4-Preço");
			

		int op = Integer.parseInt(reader.readLine());
		System.out.println("Escreva o novo valor do atributo");
		String edicao = reader.readLine();

		switch(op) {
		case 1: 
			produto.setNome(edicao);
			break;
		case 2:
			produto.setCategoria(edicao);
			break;
		case 3: 
			marca.setNomeMarca(edicao);
			break;
		case 4:
			marca.setPreco(Float.parseFloat(edicao));
			break;
		
		}
		
		
		produto.setMarca(marca);
		listaDeproduto.set(indice, produto);

		try(BufferedWriter buffer = new BufferedWriter(new FileWriter("CadastroDeAluno.txt"));
				PrintWriter pw = new PrintWriter(buffer)){
			for (Produto a:listaDeproduto)
				pw.println(a);
			
		}
	}

	public static void ListarProdutoSalvo() {
		// TODO Auto-generated method stub
		
	}


}

//txt é um arquivo permanente 

