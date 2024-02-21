package br.com.nanodata.importxml.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.nanodata.importxml.model.NotaFiscal;
import br.com.nanodata.importxml.model.NotaFiscalFile;

public class NotaFiscalDTO {

	private String idNotaFiscal;

	private LocalDateTime dataEmissao;

	private Long numeroNota;

	private Long cUF;

	private Long cnpjEmitente;

	private String nomeFantasiaEmitente;

	private Long cnpjDestinatario;

	private String nomeDestinatario;

	private BigDecimal valorTotalTributos;

	private BigDecimal valorTotalNota;

	private NotaFiscalFile notaFiscalFile;

	public String getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public Long getNumeroNota() {
		return numeroNota;
	}

	public Long getcUF() {
		return cUF;
	}

	public Long getCnpjEmitente() {
		return cnpjEmitente;
	}

	public String getNomeFantasiaEmitente() {
		return nomeFantasiaEmitente;
	}

	public Long getCnpjDestinatario() {
		return cnpjDestinatario;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public BigDecimal getValorTotalTributos() {
		return valorTotalTributos;
	}

	public BigDecimal getValorTotalNota() {
		return valorTotalNota;
	}

	public NotaFiscalFile getNotaFiscalFile() {
		return notaFiscalFile;
	}

	
	public NotaFiscalDTO(NotaFiscal notaFiscal) {
		this.idNotaFiscal = notaFiscal.getIdNotaFiscal();
		this.dataEmissao = notaFiscal.getDataEmissao();
		this.numeroNota = notaFiscal.getNumeroNota();
		this.cUF = notaFiscal.getcUF();
		this.cnpjEmitente = notaFiscal.getCnpjEmitente();
		this.nomeFantasiaEmitente = notaFiscal.getNomeFantasiaEmitente();
		this.cnpjDestinatario = notaFiscal.getCnpjDestinatario();
		this.nomeDestinatario = notaFiscal.getNomeDestinatario();
		this.valorTotalTributos = notaFiscal.getValorTotalTributos();
		this.valorTotalNota = notaFiscal.getValorTotalNota();
		this.notaFiscalFile = notaFiscal.getNotaFiscalFile();
	}

	public static List<NotaFiscalDTO> converter(List<NotaFiscal> listaNotaFiscal) {
		return listaNotaFiscal.stream().map(NotaFiscalDTO::new).collect(Collectors.toList());
	}
}
