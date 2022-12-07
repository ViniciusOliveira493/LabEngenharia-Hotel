package br.edu.fateczl.Hotel.model.entity;

import java.io.Serializable;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReservaServicoID implements Serializable {
	private static final long serialVersionUID = 1L;

	public ReservaServicoID() {
		// TODO Auto-generated constructor stub
	}

	public ReservaServicoID(Servico sID, Reserva tipoDocumento, Reserva dataInicio, Reserva pessoaDocumento,
			Reserva quartoID) {
		this.sID = sID;
		this.tipoDocumento = tipoDocumento;
		this.dataInicio = dataInicio;
		this.pessoaDocumento = pessoaDocumento;
		this.quartoID = quartoID;
	}

	@ManyToOne(targetEntity = Servico.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "id", nullable = false)
	private Servico sID;

	@ManyToOne(targetEntity = Reserva.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "tipoDocumento", nullable = false)
	private Reserva tipoDocumento;

	@ManyToOne(targetEntity = Reserva.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "dataInicio", nullable = false)
	private Reserva dataInicio;

	@ManyToOne(targetEntity = Reserva.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "documento", nullable = false)
	private Reserva pessoaDocumento;

	@ManyToOne(targetEntity = Reserva.class, fetch = FetchType.EAGER)
	@JoinColumn(name = "quarto", nullable = false)
	private Reserva quartoID;

	public Servico getsID() {
		return sID;
	}

	public void setsID(Servico sID) {
		this.sID = sID;
	}

	public Reserva getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(Reserva tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public Reserva getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Reserva dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Reserva getPessoaDocumento() {
		return pessoaDocumento;
	}

	public void setPessoaDocumento(Reserva pessoaDocumento) {
		this.pessoaDocumento = pessoaDocumento;
	}

	public Reserva getQuartoID() {
		return quartoID;
	}

	public void setQuartoID(Reserva quartoID) {
		this.quartoID = quartoID;
	}

}
