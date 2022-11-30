package br.edu.fateczl.Hotel.model.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.jayway.jsonpath.ParseContext;

import br.edu.fateczl.Hotel.model.dto.ReservaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbReserva")

public class Reserva implements IEntity<ReservaDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@JoinColumn(name = "datainicio", nullable = false)
	private String dataInicio;

	@Column(name = "datafim", nullable = false)
	private String dataFim;

	@Column(name = "documento", length = 20, nullable = false)
	private PessoaID documento;

	@Column(name = "tipodocumento", length = 10, nullable = false)
	private PessoaID tipoDocumento;

	@Column(name = "quartoID", nullable = true)
	private QuartoID quartoID;

	@Column(name = "vagaEstacionamento", nullable = true)
	private VagaId vagaEstacionamento;

	@Column(name = "numVaga", nullable = true)
	private VagaId numVaga;

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataFim() {
		return dataFim;
	}

	public void setDataFim(String dataFim) {
		this.dataFim = dataFim;
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

	public VagaId getVagaEstacionamento() {
		return vagaEstacionamento;
	}

	public void setVagaEstacionamento(VagaId vagaEstacionamento) {
		this.vagaEstacionamento = vagaEstacionamento;
	}

	public VagaId getNumVaga() {
		return numVaga;
	}

	public void setNumVaga(VagaId numVaga) {
		this.numVaga = numVaga;
	}

	public void converterDataInicio(String d_inicio) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDateTime dt = LocalDateTime.parse(d_inicio, formatter);
	}
	
	public void converterDataFim(String d_fim) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/mm/yyyy");
		LocalDateTime dt = LocalDateTime.parse(d_fim, formatter);
	}

	@Override
	public ReservaDTO toDTO() {
		ReservaDTO dto = new ReservaDTO();
		dto.setDocumento(this.documento);
		dto.setQuartoID(this.quartoID);
		dto.setTipoDocumento(this.tipoDocumento);
		dto.setVagaEstacionamento(this.vagaEstacionamento);
		dto.setDataInicio(this.dataInicio);
		dto.setDataFim(this.dataFim);
		dto.setNumVaga(this.numVaga);
		return dto;
	}

}