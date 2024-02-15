package br.com.nanodata.importxml.importxml.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.nanodata.importxml.importxml.model.NotaFiscal;
import br.com.nanodata.importxml.importxml.processor.NotaFiscalProcessor;
import br.com.nanodata.importxml.importxml.repository.NotaFiscalRepository;

@Service
public class NotaFiscalService {
	
	@Autowired
	NotaFiscalRepository repositorio;
	
	@Autowired
	NotaFiscalProcessor processadorXml;

	public List<NotaFiscal> obterNotas() {
		return repositorio.findAll();
	}
	
	public void salvarNotaFiscal(NotaFiscal notaFiscal) {
		repositorio.save(notaFiscal);
	}

	public void processaXML(MultipartFile arquivoXml) throws IOException {
		salvarNotaFiscal(processadorXml.processa(arquivoXml));
	}
	
	public ByteArrayResource getArquivo(String idNFe) {
		Optional<NotaFiscal> arquivo = repositorio.findById(idNFe);
		if(arquivo.isPresent()) {
			return new ByteArrayResource(arquivo.get().getNotaFiscalFile().getConteudo());
		}
		return null;
	}
}
