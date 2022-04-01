package Util;
//Para classes que n�o se encaixam em outros pacotes mas podem ser necess�rias para a realiza��o do programa

import java.util.ArrayList;
import java.util.List;

import Modelos.Produto;

public class ListaDeProdutos {
	
	private static List<Produto> listaDeProduto = new ArrayList<Produto>(); //Para criar a lista

	public static List<Produto> getInstance() { //M�todo para ser chamado quando a lista precisar ser carregada
		return listaDeProduto;
	}
}
