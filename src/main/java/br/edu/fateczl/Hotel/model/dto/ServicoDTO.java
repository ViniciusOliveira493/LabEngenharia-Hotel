package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Servico;

public class ServicoDTO implements IDTO<Servico>{
	private Integer codigo;
	private String nome;
	private Double valor;

	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	@Override
	public Servico toEntity() {
		Servico s = new Servico();
		s.setCodigo(this.codigo);
		s.setNome(this.nome);
		s.setValor(this.valor);
		return s;
	}
	
	

}
