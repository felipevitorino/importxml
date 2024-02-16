package br.com.nanodata.importxml.processor;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import br.com.nanodata.importxml.model.NotaFiscal;
import br.com.nanodata.importxml.model.NotaFiscalFile;

/**
 * Classe responsável em processar o arquivo XML.
 * 
 * Definido utilizar xPath devido a performance no processamento.
 */
@Service
public class NotaFiscalProcessor {

	private Document document;
	final private javax.xml.xpath.XPath xPath = XPathFactory.newInstance().newXPath();

	public NotaFiscal processa(MultipartFile arquivoXml) {
		try (InputStream file = arquivoXml.getInputStream()) {

			parseDocument(arquivoXml);

			final var id             = extractNode("/nfeProc/NFe/infNFe/@Id");
			final var dhEmissao      = extractNode("/nfeProc/NFe/infNFe/ide/dhEmi/text()");
			final var numeroNF       = extractNode("/nfeProc/NFe/infNFe/ide/nNF/text()");
			final var codigoUF       = extractNode("/nfeProc/NFe/infNFe/ide/cUF/text()");
			final var cnpjEmit       = extractNode("/nfeProc/NFe/infNFe/emit/CNPJ/text()");
			final var xFantasia      = extractNode("/nfeProc/NFe/infNFe/emit/xFant/text()");
			final var cnpjDest       = extractNode("/nfeProc/NFe/infNFe/dest/CNPJ/text()");
			final var xNome          = extractNode("/nfeProc/NFe/infNFe/dest/xNome/text()");
			final var valorTotalTrib = extractNode("/nfeProc/NFe/infNFe/total/ICMSTot/vTotTrib/text()");
			final var valorNF        = extractNode("/nfeProc/NFe/infNFe/total/ICMSTot/vNF/text()");

			return parseVariaveis(id, dhEmissao, numeroNF, codigoUF, cnpjEmit, xFantasia, cnpjDest, xNome,
					valorTotalTrib, valorNF, file);

		} catch (Exception e) {
			throw new RuntimeException("Erro ao processar XML da NF.", e);
		}
	}

	/**
	 * Converte as variaveis do tipo Node para uso no contrutor de uma NF.
	 * @param file 
	 * @throws IOException 
	 */
	private NotaFiscal parseVariaveis(Node id, Node dhEmissao, Node numeroNF, Node codigoUF, Node cnpjEmit,
			Node xFantasia, Node cnpjDest, Node xNome, Node valorTotalTrib, Node valorNF, InputStream file)
			throws Exception {
		
		NotaFiscal nf = new NotaFiscal(
				id.getNodeValue(),
				LocalDateTime.parse(dhEmissao.getNodeValue(), DateTimeFormatter.ISO_OFFSET_DATE_TIME),
				Long.valueOf(numeroNF.getNodeValue()),
				Long.valueOf(codigoUF.getNodeValue()),
				Long.valueOf(cnpjEmit.getNodeValue()),
				xFantasia.getNodeValue(),
				Long.valueOf(cnpjDest.getNodeValue()),
				xNome.getNodeValue(),
				new BigDecimal(valorTotalTrib.getNodeValue()),
				new BigDecimal(valorNF.getNodeValue()),
				new NotaFiscalFile(id.getNodeValue(), file.readAllBytes()));
		
		return nf;
	}

	/**
	 * Converte o arquivo para objeto.
	 * 
	 * @param arquivoXml
	 * @throws ParserConfigurationException
	 * @throws SAXException
	 * @throws IOException
	 */
	private void parseDocument(MultipartFile arquivoXml) throws Exception {
		final DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		final DocumentBuilder builder = domFactory.newDocumentBuilder();
		document = builder.parse(arquivoXml.getInputStream());
	}
	
    /**
     * Extrai o valor do xml para uma variavel tipo Node
     * 
     * @param xpathExpression
     * @return
     * @throws XPathExpressionException
     */
    private Node extractNode(String xpathExpression) throws XPathExpressionException {
        return (Node) xPath.evaluate(xpathExpression, document, XPathConstants.NODE);
    }

}
