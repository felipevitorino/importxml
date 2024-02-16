package br.com.nanodata.importxml.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.nanodata.importxml.model.NotaFiscal;
import br.com.nanodata.importxml.processor.NotaFiscalProcessor;
import br.com.nanodata.importxml.repository.NotaFiscalRepository;

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
	
	public NotaFiscal obterPorId(String id) {
		Optional<NotaFiscal> nf = repositorio.findById(id);
		
		if (nf.isPresent()) {
			return nf.get();
		}
		return null;
	}

	public void processaXML(MultipartFile arquivoXml) throws IOException {
		salvarNotaFiscal(processadorXml.processa(arquivoXml));
	}
	
	public ByteArrayResource getArquivo(String idNFe) {
		Optional<NotaFiscal> nf = repositorio.findById(idNFe);
		if(nf.isPresent()) {
			return new ByteArrayResource(nf.get().getNotaFiscalFile().getConteudo());
		}
		return null;
	}
	
	public void apagaNotaPorId(String Id) {
		repositorio.deleteById(Id);
	}
}
