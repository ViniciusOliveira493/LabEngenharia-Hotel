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
public class FuncionarioController extends Controller<PessoaDTO>{
	@Autowired
	PessoaRepository rep;
	
	@Override
	@GetMapping("/funcionario")
	public List<PessoaDTO> findAll() {
		// TODO Auto-generated method stub
		// Criar native querie para buscar apenas funcionarios
		// Deixando o find all de pessoas temporariamente
		List<Pessoa> pessoas = rep.findAll();
		List<PessoaDTO> pessoasDTO = new ArrayList<>();
		
		for(Pessoa p:pessoas) {
			pessoasDTO.add(p.toDTO());
		}
		return pessoasDTO;
	}

	@GetMapping("/funcionario/{tipoDocumento}/{documento}")
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
	@PostMapping("/funcionario")
	public ResponseEntity<String> insert(@Valid PessoaDTO obj) {
		Optional<Pessoa> p = rep.findById(obj.getId());
		if(p.isEmpty()) {
			rep.save(obj.toEntity());
			return ResponseEntity.ok().body(this.sucesso(1));
		}else {
			rep.save(obj.toEntity());
			return ResponseEntity.ok().body(this.sucesso(2));
		}
	}

	@Override
	@PutMapping("/funcionario")
	public ResponseEntity<String> update(PessoaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(2));
	}

	@Override
	@DeleteMapping("/funcionario")
	public ResponseEntity<String> delete(PessoaDTO obj) {
		obj.setFuncao(Pessoa.CLIENTE);
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(3));
	}

	@Override
	public ResponseEntity<PessoaDTO> findOne(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}

}
