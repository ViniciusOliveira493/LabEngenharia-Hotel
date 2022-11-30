package br.edu.fateczl.Hotel.model.entity;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import br.edu.fateczl.Hotel.model.dto.PessoaDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

@Entity
@Table(name = "tbPessoa")
@NamedNativeQuery(
		name = "Pessoa.fn_findAllFuncionarios"
		,query = "  SELECT"
					+ " p.documento"
					+ " ,p.tipoDocumento"
					+ " ,p.email"
					+ " ,p.funcao"
					+ " ,p.nome"
					+ " ,p.senha"
					+ " ,p.telefone"
				+ " from "
					+ " tbPessoa as p"
				+ " WHERE"
					+ "	funcao != 3"
		,resultClass = Pessoa.class
)
@NamedNativeQuery(
		name = "Pessoa.fn_login"
		,query = "  SELECT"
					+ " p.documento"
					+ " ,p.tipoDocumento"
					+ " ,p.email"
					+ " ,p.funcao"
					+ " ,p.nome"
					+ " ,p.senha"
					+ " ,p.telefone"
				+ " from "
					+ " tbPessoa as p"
				+ " WHERE"
					+ "	p.email = ?1 AND p.senha = ?2"
		,resultClass = Pessoa.class
)
public class Pessoa implements IEntity<PessoaDTO>{
	public static final int ADMIN = 0;
	public static final int GERENTE = 1;
	public static final int ATENDENTE = 2;
	public static final int CLIENTE = 3;
	public static final int INATIVO = 9;
	
	@EmbeddedId
	private PessoaID id;
	
	@Column(name = "nome",length = 80,nullable = false)
	private String nome;
	@Column(name = "email",length = 255,nullable = false)
	private String email;
	@Column(name = "senha",length = 32,nullable = false)//Senha usará md5 
	private String senha;
	@Column(name = "telefone",length = 20,nullable = false)
	private String telefone;
	
	@Column(name = "funcao",nullable = false) 
	private Integer funcao = 3;
	
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
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public PessoaDTO toDTO() {
		PessoaDTO dto = new PessoaDTO();
		dto.setId(this.id);
		dto.setEmail(this.getEmail());
		dto.setNome(this.getNome());
		dto.setTelefone(this.getTelefone());
		dto.setFuncao(this.funcao);
		return dto;
	}
}
