package br.com.nanodata.importxml.importxml.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "nota_fiscal_file")
public class NotaFiscalFile implements Serializable{
	
	private static final long serialVersionUID = 1L;

	public NotaFiscalFile(Long notaFiscalId, byte[] conteudo){
		this.notaFiscalId = notaFiscalId;
		this.conteudo = conteudo;
	}
	
	public NotaFiscalFile() {}

	@Id
	@Column(name = "nota_fiscal_id")
	private Long notaFiscalId;

	@Lob
	private byte[] conteudo;

	public Long getNotaFiscalId() {
		return notaFiscalId;
	}

	public void setNotaFiscalId(Long notaFiscalId) {
		this.notaFiscalId = notaFiscalId;
	}

	public byte[] getConteudo() {
		return conteudo;
	}

	public void setConteudo(byte[] conteudo) {
		this.conteudo = conteudo;
	}

}
