package Aplicação;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;


public class Main {

	public static void main(String[] args) {

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		List<Produto> listaProduto = new ArrayList<Produto>();

		int menu = 0;
		while (menu != 5) {

			System.out.println("1- Cadastro de Produtos");
			System.out.println("2- Listar Produtos");
			System.out.println("3- Deletar Produto");
			System.out.println("4- Editar Produto");
			System.out.println("5- Sair");

			try {
				menu = (Integer.parseInt(reader.readLine()));

				switch (menu) {
				case 1:

					listaProduto.add(CRUDProduto.SalvarProduto(reader));
					break;
//					for (Produto a : listaProduto)
//						System.out.println(a);
					
				case 2:
					CRUDProduto.ListarProdutosSalvos(0);
					break;
					
				case 3:
					CRUDProduto.DeletarProduto(reader);
					break;
				
				case 4:
					CRUDProduto.EditarProduto(reader);
					break;

				}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
