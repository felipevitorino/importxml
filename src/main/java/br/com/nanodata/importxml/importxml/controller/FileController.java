package br.com.nanodata.importxml.importxml.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.nanodata.importxml.dto.NotaFiscalDTO;
import br.com.nanodata.importxml.importxml.service.NotaFiscalService;

@RestController
@RequestMapping("/notafiscal")
public class FileController {
	
	private NotaFiscalService servico;
	
    @GetMapping
    public List<NotaFiscalDTO> obterNotas() {
        return servico.obterNotas();
    }
	
	@GetMapping("/teste")
    public String teste() {
        return "Teste";
    }
    
    @GetMapping("/{id}")
    public NotaFiscalDTO obterPorId(@PathVariable Long id) {
        return servico.obterPorId(id);
    }

}
