package br.edu.fateczl.Hotel.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.ProdutoDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbProduto")
public class Produto implements IEntity<ProdutoDTO>{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigo", length = 10, nullable = false)
	private Integer codigo;

	@Column(name = "nome", length = 50, nullable = false)
	private String nome;

	@ManyToOne(targetEntity = UnidadeDeMedida.class, fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	private UnidadeDeMedida UdM;

	@Column(name = "valor", nullable = false)
	private Double valor;

	@Column(name = "conteudo", nullable = false)
	private Double conteudo;

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

	public UnidadeDeMedida getUdM() {
		return UdM;
	}

	public void setUdM(UnidadeDeMedida udM) {
		UdM = udM;
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

	@Override
	public ProdutoDTO toDTO() {
		ProdutoDTO dto = new ProdutoDTO();
		dto.setCodigo(this.codigo);
		dto.setNome(this.nome);
		dto.setUdM(this.UdM.toDTO());
		dto.setValor(this.valor);
		dto.setConteudo(this.conteudo);
		return dto;
	}

}
