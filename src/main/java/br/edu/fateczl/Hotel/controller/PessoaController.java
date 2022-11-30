package br.edu.fateczl.Hotel.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.fateczl.Hotel.controller.interfaces.Controller;
import br.edu.fateczl.Hotel.model.dto.PessoaDTO;
import br.edu.fateczl.Hotel.model.entity.Pessoa;
import br.edu.fateczl.Hotel.model.entity.PessoaID;
import br.edu.fateczl.Hotel.model.entity.TipoDocumento;
import br.edu.fateczl.Hotel.repository.PessoaRepository;

@RestController
@RequestMapping("/api")
public class PessoaController extends Controller<PessoaDTO>{
	@Autowired
	PessoaRepository rep;
	
	
	@Override
	@GetMapping("/pessoa")
	public List<PessoaDTO> findAll() {
		List<Pessoa> pessoas = rep.findAll();
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		
		for(Pessoa p:pessoas) {
			pessoasDTO.add(p.toDTO());
		}
		return pessoasDTO;
	}

	@GetMapping("/pessoa/{tipoDocumento}/{documento}")
	public ResponseEntity<PessoaDTO> findOne(
			@PathVariable(name = "documento") String doc,
				@PathVariable(name = "tipoDocumento") Integer tipo) {
		PessoaID id = new PessoaID();
		id.setDocumento(doc);
		TipoDocumento td = new TipoDocumento();
		td.setId(tipo);
		id.setTipoDocumento(td);
		Optional<Pessoa> p = rep.findById(id);
		Pessoa pessoa = p.orElseThrow(()-> new ResourceNotFoundException(this.notFound("uma pessoa ", doc)));
		return ResponseEntity.ok().body(pessoa.toDTO());
	}

	@Override
	@PostMapping("/pessoa")
	public ResponseEntity<String> insert(@Valid @RequestBody PessoaDTO obj) {
		if(obj.getSenha() == null || obj.getSenha() == "") {
			obj.setSenha(obj.getTelefone());
		}
		
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(1));
	}

	@PostMapping("/login")
	public ResponseEntity<PessoaDTO> login(@Valid @RequestBody PessoaDTO obj) {
		Pessoa p = rep.fn_login(obj.getEmail(), obj.getSenha());
		if(p != null) {
			return ResponseEntity.ok().body(p.toDTO());
		}
		return ResponseEntity.ok().body(null);
	}
	
	@Override
	@PutMapping("/pessoa")
	public ResponseEntity<String> update(@Valid @RequestBody PessoaDTO obj) {
		System.out.println("senha ctrl = "+obj.getSenha());
		if(obj.getSenha() == null) {
			obj.setSenha(null);
		}
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(2));
	}

	@Override
	@DeleteMapping("/pessoa")
	public ResponseEntity<String> delete(@Valid @RequestBody PessoaDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(3));
	}

	@Override
	public ResponseEntity<PessoaDTO> findOne(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

	public Pessoa getPessoa(PessoaID id) {
		Optional<Pessoa> p = rep.findById(id);
		Pessoa pessoa = p.orElseThrow(()-> new ResourceNotFoundException("Não encontrado..."));
		return pessoa;
	}
	
}
