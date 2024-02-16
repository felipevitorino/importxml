package br.com.nanodata.importaxml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import br.com.nanodata.importxml.ImportaXmlApplication;
import br.com.nanodata.importxml.service.NotaFiscalService;

@SpringBootTest
@ContextConfiguration(classes = ImportaXmlApplication.class)
class ImportaXmlApplicationTest {

	@Autowired
	private NotaFiscalService servico;
	private String id = "NFe35240100000000000001550010000117371016243501";
	
	@BeforeEach
	public void setup() {
	}
	
	@Test
	public void deveInserirEApagarUmaNotaFiscalDoBancoDeDados() throws Exception {

		servico.processaXML(new CriadorDeNotaFiscalFileWithResource().getNfFile());
		assertEquals(servico.obterPorId(id).getIdNotaFiscal(), id);
		
		servico.apagaNotaPorId(id);
		assertEquals(servico.obterPorId(id), null);
	}
}
