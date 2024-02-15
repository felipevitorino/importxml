package br.com.nanodata.importxml.importxml.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota_fiscal")
public class NotaFiscal implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public NotaFiscal() {}

	public NotaFiscal(String idNotaFiscal, LocalDateTime dataEmissao, Long numeroNota, Long cUF, Long cnpjEmitente,
			String nomeFantasiaEmitente, Long cnpjDestinatario, String nomeDestinatario, BigDecimal valorTotalTributos,
			BigDecimal valorTotalNota, NotaFiscalFile file) {
		this.idNotaFiscal         = idNotaFiscal;
		this.dataEmissao          = dataEmissao;
		this.numeroNota           = numeroNota;
		this.cUF                  = cUF;
		this.cnpjEmitente         = cnpjEmitente;
		this.nomeFantasiaEmitente = nomeFantasiaEmitente;
		this.cnpjDestinatario     = cnpjDestinatario;
		this.nomeDestinatario     = nomeDestinatario;
		this.valorTotalTributos   = valorTotalTributos;
		this.valorTotalNota       = valorTotalNota;
		this.notaFiscalFile       = file;
	}

	@Id
	@Column(name = "id_nota_fiscal")
	private String idNotaFiscal;

	@Column(name = "data_emissao")
    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dataEmissao;

	@Column(name = "numero_nota")
	private Long numeroNota;

	@Column(name = "cuf")
	private Long cUF;

	@Column(name = "cnpj_emitente")
	private Long cnpjEmitente;

	@Column(name = "nome_fantasia_emitente")
	private String nomeFantasiaEmitente;

	@Column(name = "cnpj_destinatario")
	private Long cnpjDestinatario;

	@Column(name = "nome_destinatario")
	private String nomeDestinatario;

	@Column(name = "valor_total_tributos")
	private BigDecimal valorTotalTributos;

	@Column(name = "valor_total_nota")
	private BigDecimal valorTotalNota;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	@PrimaryKeyJoinColumn(name = "id_nota_fiscal", referencedColumnName = "nota_fiscal_id")
	private NotaFiscalFile notaFiscalFile;

	public String getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(String idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public LocalDateTime getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDateTime dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Long getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(Long numeroNota) {
		this.numeroNota = numeroNota;
	}

	public Long getcUF() {
		return cUF;
	}

	public void setcUF(Long cUF) {
		this.cUF = cUF;
	}

	public Long getCnpjEmitente() {
		return cnpjEmitente;
	}

	public void setCnpjEmitente(Long cnpjEmitente) {
		this.cnpjEmitente = cnpjEmitente;
	}

	public String getNomeFantasiaEmitente() {
		return nomeFantasiaEmitente;
	}

	public void setNomeFantasiaEmitente(String nomeFantasiaEmitente) {
		this.nomeFantasiaEmitente = nomeFantasiaEmitente;
	}

	public Long getCnpjDestinatario() {
		return cnpjDestinatario;
	}

	public void setCnpjDestinatario(Long cnpjDestinatario) {
		this.cnpjDestinatario = cnpjDestinatario;
	}

	public String getNomeDestinatario() {
		return nomeDestinatario;
	}

	public void setNomeDestinatario(String nomeDestinatario) {
		this.nomeDestinatario = nomeDestinatario;
	}

	public BigDecimal getValorTotalTributos() {
		return valorTotalTributos;
	}

	public void setValorTotalTributos(BigDecimal valorTotalTributos) {
		this.valorTotalTributos = valorTotalTributos;
	}

	public BigDecimal getValorTotalNota() {
		return valorTotalNota;
	}

	public void setValorTotalNota(BigDecimal valorTotalNota) {
		this.valorTotalNota = valorTotalNota;
	}

	public NotaFiscalFile getNotaFiscalFile() {
		return notaFiscalFile;
	}

	public void setNotaFiscalFile(NotaFiscalFile notaFiscalFile) {
		this.notaFiscalFile = notaFiscalFile;
	}

}
