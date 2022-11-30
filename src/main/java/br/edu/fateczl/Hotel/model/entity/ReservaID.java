package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class ReservaID implements Serializable {
	private static final long serialVersionUID = 1L;

	public ReservaID() {
		// TODO Auto-generated constructor stub
	}

	public ReservaID(String dataInicio, PessoaID documento, PessoaID tipoDocumento, QuartoID quartoID) {
		this.dataInicio = dataInicio;
		this.documento = documento;
		this.tipoDocumento = tipoDocumento;
		this.quartoID = quartoID;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public PessoaID getDocumento() {
		return documento;
	}

	public void setDocumento(PessoaID documento) {
		this.documento = documento;
	}

	public PessoaID getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(PessoaID tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public QuartoID getQuartoID() {
		return quartoID;
	}

	public void setQuartoID(QuartoID quartoID) {
		this.quartoID = quartoID;
	}

	@Column(name = "datainicio", nullable = false)
	private String dataInicio;

	@Column(name = "documento", length = 20, nullable = false)
	private PessoaID documento;

	@Column(name = "tipodocumento", length = 10, nullable = false)
	private PessoaID tipoDocumento;

	@Column(name = "quartoID", nullable = true)
	private QuartoID quartoID;

}
