package br.com.nanodata.importxml.importxml.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.nanodata.importxml.dto.NotaFiscalDTO;
import br.com.nanodata.importxml.importxml.model.NotaFiscal;
import br.com.nanodata.importxml.importxml.repository.NotaFiscalRepository;

public class NotaFiscalService {
	
	@Autowired
	NotaFiscalRepository repositorio;

	public List<NotaFiscalDTO> obterNotas() {
		// TODO Auto-generated method stub
		return null;
	}

	public NotaFiscalDTO obterPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void salvarNotaFiscal(NotaFiscal notaFiscal) {
		repositorio.save(notaFiscal);
	}

}
