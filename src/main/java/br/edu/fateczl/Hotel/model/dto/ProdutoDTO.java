package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Produto;

public class ProdutoDTO implements IDTO<Produto> {

	private Integer id;
	private String nome;
	private Double valor;
	private Double conteudo;
	private UnidadeDeMedidaDTO UdM;

	public Integer getCodigo() {
		return id;
	}

	public void setCodigo(Integer codigo) {
		this.id = codigo;
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

	public Double getConteudo() {
		return conteudo;
	}

	public void setConteudo(Double conteudo) {
		this.conteudo = conteudo;
	}

	public UnidadeDeMedidaDTO getUdM() {
		return UdM;
	}

	public void setUdM(UnidadeDeMedidaDTO udM) {
		UdM = udM;
	}

	@Override
	public Produto toEntity() {
		Produto p = new Produto();
		p.setCodigo(this.id);
		p.setNome(this.nome);
		p.setUdM(this.UdM.toEntity());
		return p;
	}

}
