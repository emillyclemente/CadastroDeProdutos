package Aplicação;
//Pacote utilizado para manipular o objeto

import java.io.BufferedReader;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import BancoDeDados.ManipulacaoArquivoTXT;
import BancoDeDados.ManipulacaoArquivoXML;
import Modelos.Marca;
import Modelos.Produto;
import Util.ListaDeProdutos;
import View.ViewCRUDProduto;

public class CRUDProduto {

	public static void SalvarProduto(BufferedReader reader) throws IOException, ParserConfigurationException, TransformerException { //Objeto criado sem utilizar o "new", e sim o static.
		//Método utilizado para salvar as informações inseridas pelo usuário
		
		
		Produto produto = new Produto();
		Marca marca = new Marca();

		String[] dadosProduto = ViewCRUDProduto.ViewMenuSalvarProduto(reader);

		produto.setNome(dadosProduto[0]);
		produto.setCategoria(dadosProduto[1]);
		marca.setNomeMarca(dadosProduto[2]);
		marca.setPreco(Float.parseFloat(dadosProduto[3]));
		produto.setMarca(marca);

		ListaDeProdutos.getInstance().add(produto);
		
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(0);
	}


	public static void ListarProdutosSalvos() throws IOException {
		//Método utilizado para carregar a lista e mostrar as informações salvas inseridas pelo usuário
		ListaDeProdutos.getInstance().clear();
		ManipulacaoArquivoTXT.LerArquivoTXT();
		ViewCRUDProduto.ViewListaDeProdutosEditada();

	}


	public static void DeletarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		//Método utilizado para deletar da lista um produto cadastrado
		int indice = ViewCRUDProduto.ViewMenuListaIndexada("deletar", reader);
		ListaDeProdutos.getInstance().remove(indice);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(1);
	}


	public static void EditarProduto(BufferedReader reader) throws NumberFormatException, IOException, ParserConfigurationException, TransformerException {
		//Método utilizado para editar algum atributo inserido de um produto cadastrado
		int indice = ViewCRUDProduto.ViewMenuListaIndexada("editar", reader);
		String[] dadosEditados = {"",""};
		Produto produtos = ListaDeProdutos.getInstance().get(indice);

		dadosEditados = ViewCRUDProduto.ViewOpcaoEdicao(reader);

		switch(Integer.parseInt(dadosEditados[0])) {
		case 1:
			produtos.setNome(dadosEditados[1]);
			break;
		case 2:
			produtos.setCategoria(dadosEditados[1]);
			break;
		case 3:
			produtos.getMarca().setNomeMarca(dadosEditados[1]);
			break;
		case 4:
			produtos.getMarca().setPreco(Float.parseFloat(dadosEditados[1]));
			break;
		}

		ListaDeProdutos.getInstance().set(indice, produtos);
		ManipulacaoArquivoTXT.SalvarArquivoTXT();
		ManipulacaoArquivoXML.SalvarArquivoXML();
		ViewCRUDProduto.ViewMsgFinal(2);
	}
}


