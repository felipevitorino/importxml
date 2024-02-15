package br.com.nanodata.importxml.importxml.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.nanodata.importxml.importxml.model.NotaFiscal;
import br.com.nanodata.importxml.importxml.service.NotaFiscalService;

@RestController
@RequestMapping("/notafiscal")
public class FileController {

	private static final String TEXT_XML = "text/xml";

	@Autowired
	private NotaFiscalService servico;

	@PostMapping("/upload")
	public ResponseEntity<String> uploadArquivosXml(@RequestParam("arquivo") MultipartFile[] arquivosXml) {
		try {
			for (MultipartFile arquivoXml : arquivosXml) {
				// Verificar se o arquivo é XML
				if (!arquivoXml.getContentType().equals(TEXT_XML)) {
					return ResponseEntity.badRequest().body("Apenas arquivos XML são permitidos.");
				}
				servico.processaXML(arquivoXml);
			}
			return ResponseEntity.status(HttpStatus.CREATED).body("Arquivos XML foram enviados com sucesso.");
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao processar arquivos XML.");
		}
	}

	@GetMapping
	public List<NotaFiscal> obterNotas() {
		return servico.obterNotas();
	}
	
	@GetMapping("/download/{idNfe}")
	public ResponseEntity<ByteArrayResource>  download(@PathVariable("idNfe") String idNFe) {
		
        ByteArrayResource resource = servico.getArquivo(idNFe);
        
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + idNFe + ".ext"); // Nome do arquivo
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        // Retornar a resposta com os bytes do arquivo
        return ResponseEntity.ok()
                .headers(headers)
                .body(resource);
	}

}
