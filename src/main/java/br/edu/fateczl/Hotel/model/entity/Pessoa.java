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
public class Pessoa implements IEntity<PessoaDTO>{
	public static final int ADMIN = 0;
	public static final int GERENTE = 1;
	public static final int ATENDENTE = 2;
	public static final int CLIENTE = 3;
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
		this.senha = MD5(senha);
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
	
	public static String MD5(String txt) {
		
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			return new String(hexCodes(md.digest(txt.getBytes())));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		return "ERROR_90_43_21";
	}
	
	private static char[] hexCodes(byte[] text) {
        char[] hexOutput = new char[text.length * 2];
        String hexString;

        for (int i = 0; i < text.length; i++) {
            hexString = "00" + Integer.toHexString(text[i]);
            hexString.toUpperCase().getChars(hexString.length() - 2,
                                    hexString.length(), hexOutput, i * 2);
        }
        return hexOutput;
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
