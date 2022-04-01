package BancoDeDados;
//Pacote utilizado para manipular os bancos de dados

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulacaoArquivoTXT {

	private static String nomeDoArquivo = "ProdutosCadastrados.txt";

	public static void SalvarArquivoTXT() throws IOException { //Escrever as informações cadastradas pelo usuário no txt e salvar la
		
		try(BufferedWriter buffer = new BufferedWriter(new FileWriter(nomeDoArquivo ));
				PrintWriter pw = new PrintWriter(buffer)){
			for(Produto a: ListaDeProdutos.getInstance()) {
				pw.println(a);
			}	
		}
}
	
	public static void LerArquivoTXT() throws FileNotFoundException, IOException { //Ler o arquivo do txt e carregar na lista
		
		try (FileWriter arq = new FileWriter(nomeDoArquivo,true)){};
		String line;

		try(BufferedReader reader = new BufferedReader(new FileReader(nomeDoArquivo)))  {

			while((line = reader.readLine())!= null&& !"".equals(line)) { //Checagem de linha para ver se ela não esta vazia ou em branco

				Produto produto = new Produto(line);
				ListaDeProdutos.getInstance().add(produto);
			}
		}
	}
}