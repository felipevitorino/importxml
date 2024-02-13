package br.com.nanodata.importxml.importxml.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
public class NotaFiscal implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_nota_fiscal")
	private Long idNotaFiscal;

	@Column(name = "data_emissao")
	private LocalDate dataEmissao;

	@Column(name = "numero_nota")
	private Long numeroNota;

	@Column(name = "cuf")
	private String cUF;

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
	@PrimaryKeyJoinColumn(name="id_nota_fiscal", referencedColumnName="nota_fiscal_id")
	private NotaFiscalFile notaFiscalFile;

	public Long getIdNotaFiscal() {
		return idNotaFiscal;
	}

	public void setIdNotaFiscal(Long idNotaFiscal) {
		this.idNotaFiscal = idNotaFiscal;
	}

	public LocalDate getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(LocalDate dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Long getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(Long numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getcUF() {
		return cUF;
	}

	public void setcUF(String cUF) {
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
