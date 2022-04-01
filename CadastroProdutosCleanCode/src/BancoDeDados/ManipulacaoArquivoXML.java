package BancoDeDados;
//Pacote utilizado para manipular os bancos de dados

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import Handler.XMLHandlerProdutos;
import Modelos.Produto;
import Util.ListaDeProdutos;

public class ManipulacaoArquivoXML {

	private static String nomeDoArquivo = "ProdutosCadastrados.xml";

	public static void SalvarArquivoXML() throws ParserConfigurationException, UnsupportedEncodingException, FileNotFoundException, IOException, TransformerException { //
		//Escrever as informações cadastradas pelo usuário no xml e salvar la
		
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = dbf.newDocumentBuilder();		
		Document doc = db.newDocument();
		// Construtores de documentos
		
		Element produtosTag = doc.createElement("Produtos"); //Primeira tag principal
		doc.appendChild(produtosTag);

		for(Produto a : ListaDeProdutos.getInstance()) {

			Element produtoTag = doc.createElement("Produto"); //Segunda tag que vai estar dentro da tag principal
			produtoTag.setAttribute("id", "1");
			produtosTag.appendChild(produtoTag);

			Element nomeTag = doc.createElement("Nome"); //tags atributos que vão estar dentro da segunda tag que esta dentro da tag principal
			nomeTag.setTextContent(a.getNome());
			produtoTag.appendChild(nomeTag);

			Element categoriaTag = doc.createElement("Categoria");
			categoriaTag.setTextContent(a.getCategoria());
			produtoTag.appendChild(categoriaTag);

			Element marcaTag = doc.createElement("MarcaProduto");
			produtoTag.appendChild(marcaTag);

			Element nomeMarcaTag = doc.createElement("Marca");
			nomeMarcaTag.setTextContent(a.getMarca().getNomeMarca());
			marcaTag.appendChild(nomeMarcaTag);

			Element precoTag = doc.createElement("Preco");
			precoTag.setTextContent(String.valueOf(a.getMarca().getPreco()));  //Para converter para String usa-se String.valueOf
			marcaTag.appendChild(precoTag);

		}

		//Formatação e identação do xml
		TransformerFactory tf = TransformerFactory.newInstance();
		Transformer trans = tf.newTransformer();

		trans.setOutputProperty(OutputKeys.INDENT, "yes");
		trans.setOutputProperty("{http://xml.apache.org/xslt}indent-amount","4");

		DOMSource source = new DOMSource(doc);

		try(OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(nomeDoArquivo),"ISO-8859-1")) {
			StreamResult result = new StreamResult(osw);
			trans.transform(source, result);
		}

	}

	public static void LerArquivoXML() throws ParserConfigurationException, SAXException, UnsupportedEncodingException, FileNotFoundException, IOException { //
		//Ler o arquivo do xml
		
		SAXParserFactory spf = SAXParserFactory.newInstance();
		SAXParser parser = spf.newSAXParser();

		try(InputStreamReader isr = new InputStreamReader(new FileInputStream(nomeDoArquivo), "ISO-8859-1")) {

			InputSource source = new InputSource(isr);
			XMLHandlerProdutos handler = new XMLHandlerProdutos();
			parser.parse(source, handler);

		}
	}
}
