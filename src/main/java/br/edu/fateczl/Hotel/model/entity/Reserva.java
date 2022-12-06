package br.edu.fateczl.Hotel.model.entity;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.ReservaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbReserva")
public class Reserva implements IEntity<ReservaDTO> {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false)
	private BigInteger id;
	
	@Column(name = "datainicio", nullable = false)
	private String dataInicio;

	@Column(name = "datafim", nullable = false)
	private String dataFim;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
	  @JoinColumn(name = "documento", nullable = false),
	  @JoinColumn(name = "tipoDocumento", nullable = false)
	})
	private Pessoa cliente;

	@ManyToOne(targetEntity = Quarto.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "quartoId", nullable = false)	
	private Quarto quarto;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumns({
	  @JoinColumn(name = "estacionamento", nullable = true),
	  @JoinColumn(name = "numvaga", nullable = true)
	})
	private Vaga vaga;

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

	public Quarto getQuarto() {
		return quarto;
	}

	public void setQuarto(Quarto quarto) {
		this.quarto = quarto;
	}

	public Vaga getVaga() {
		return vaga;
	}

	public void setVaga(Vaga vaga) {
		this.vaga = vaga;
	}

	public void converterDataInicio(String d_inicio) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dt = LocalDateTime.parse(d_inicio, formatter);
	}
	
	public void converterDataFim(String d_fim) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime dt = LocalDateTime.parse(d_fim, formatter);
	}

	public BigInteger getId() {
		return id;
	}

	public void setId(BigInteger id) {
		this.id = id;
	}

	public Pessoa getCliente() {
		return cliente;
	}

	public void setCliente(Pessoa cliente) {
		this.cliente = cliente;
	}

	@Override
	public ReservaDTO toDTO() {
		ReservaDTO dto = new ReservaDTO();
		dto.setDocumento(this.cliente);
		dto.setId(this.id);
		dto.setQuarto(this.quarto);
		dto.setDataInicio(this.dataInicio);
		dto.setDataFim(this.dataFim);
		if(this.vaga != null) {
			dto.setVaga(this.vaga);
		}		
		return dto;
	}

}