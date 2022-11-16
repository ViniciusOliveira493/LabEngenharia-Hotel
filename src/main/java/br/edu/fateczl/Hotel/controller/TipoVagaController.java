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
import br.edu.fateczl.Hotel.model.dto.TipoVagaDTO;
import br.edu.fateczl.Hotel.model.entity.TipoVaga;
import br.edu.fateczl.Hotel.repository.TipoVagaRepository;

@RestController
@RequestMapping("/api")
public class TipoVagaController extends Controller<TipoVagaDTO>{
	@Autowired
	TipoVagaRepository rep;	
	
	@Override
	@GetMapping("/tipovaga")
	public List<TipoVagaDTO> findAll() {
		List<TipoVaga> vagas = rep.findAll();
		List<TipoVagaDTO> vagasDto = new ArrayList<>();
		for(TipoVaga vaga:vagas) {
			vagasDto.add(vaga.toDTO());
		}
		return vagasDto;
	}

	@Override
	@GetMapping("/tipovaga/{id}")
	public ResponseEntity<TipoVagaDTO> findOne(@PathVariable(name = "id") Integer id) {		
		Optional<TipoVaga> tipo = rep.findById(id);
		TipoVaga t = tipo.orElseThrow(()-> new ResourceNotFoundException(this.notFound("um tipo de vaga",id+"")));
		return ResponseEntity.ok().body(t.toDTO());
	}

	@Override
	@PostMapping("/tipovaga")
	public ResponseEntity<String> insert(@Valid @RequestBody TipoVagaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(1));
	}

	@Override
	@PutMapping("/tipovaga")
	public ResponseEntity<String> update(@Valid @RequestBody TipoVagaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(2));
	}

	@Override
	@DeleteMapping("/tipovaga")
	public ResponseEntity<String> delete(@Valid @RequestBody TipoVagaDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(3));
	}

}
