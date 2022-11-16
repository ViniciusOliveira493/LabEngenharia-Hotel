package br.edu.fateczl.Hotel.model.dto;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.PessoaID;
import br.edu.fateczl.Hotel.model.entity.TipoDocumento;

public class PessoaDTO implements IDTO<Pessoa>{
	private PessoaID id;
	private String nome;
	private String senha;
	private String email;
	private String telefone;
	private Integer funcao = 3;
	
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public PessoaID getId() {
		return id;
	}
	public void setId(PessoaID id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public int getFuncao() {
		return funcao;
	}
	public void setFuncao(int funcao) {
		this.funcao = funcao;
	}
	@Override
	public Pessoa toEntity() {
		Pessoa p = new Pessoa();
		p.setEmail(this.email);
		p.setId(this.id);
		p.setNome(this.nome);
		p.setSenha(this.senha);
		p.setFuncao(this.funcao);
		System.out.println(p.getSenha());
		p.setTelefone(this.telefone);
		return p;
	}
}
