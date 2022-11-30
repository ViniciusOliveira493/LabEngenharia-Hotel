package br.edu.fateczl.Hotel.model.dto;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;

import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.PessoaID;
import br.edu.fateczl.Hotel.repository.PessoaRepository;
import br.edu.fateczl.Hotel.repository.PessoaCustomRep.RepCustomPessoa;

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
		if(senha != null) {
			this.senha = MD5(senha);
		}else {
			RepCustomPessoa rep = new RepCustomPessoa();
			this.senha = rep.senhaDoUsuario(id);
		}
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
}
