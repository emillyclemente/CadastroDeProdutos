package Util;
//Para classes que não se encaixam em outros pacotes mas podem ser necessárias para a realização do programa

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListaDeProdutos {
	
	private static List<Produto> listaDeProduto = new ArrayList<Produto>(); //Para criar a lista

	public static List<Produto> getInstance() { //Método para ser chamado quando a lista precisar ser carregada
		return listaDeProduto;
	}
}
