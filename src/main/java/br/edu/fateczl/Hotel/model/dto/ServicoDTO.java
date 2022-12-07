package br.edu.fateczl.Hotel.model.dto;

import java.util.List;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Servico;

public class ServicoDTO implements IDTO<Servico>{
	private Integer id;
	private String nome;
	private Double valor;
	private List<ProdutoDTO> produtos;
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
		s.setId(this.id);
		s.setNome(this.nome);
		s.setValor(this.valor);
		return s;
	}
	
	

}
