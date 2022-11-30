package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Produto;

public class ProdutoDTO implements IDTO<Produto> {

	private Integer codigo;
	private String nome;
	private Double valor;
	private Double conteudo;
	private UnidadeDeMedidaDTO UdM;

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
		p.setCodigo(this.codigo);
		p.setNome(this.nome);
		p.setUdM(this.UdM.toEntity());
		return p;
	}

}
