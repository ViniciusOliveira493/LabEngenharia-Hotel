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
public class TipoVagaController implements Controller<TipoVagaDTO>{
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
	public ResponseEntity<TipoVagaDTO> findOne(@PathVariable(name = "id") Integer a) {		
		Optional<TipoVaga> tipo = rep.findById(a);
		TipoVaga t = tipo.orElseThrow(()-> new ResourceNotFoundException("O tipo de vaga "+a+" não existe"));
		return ResponseEntity.ok().body(t.toDTO());
	}

	@Override
	@PostMapping("/tipovaga")
	public ResponseEntity<String> insert(@Valid @RequestBody TipoVagaDTO obj) {
		TipoVaga t = obj.toEntity();
		rep.save(t);
		String saida = "Dados cadastrados com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/tipovaga")
	public ResponseEntity<String> update(@Valid @RequestBody TipoVagaDTO obj) {
		TipoVaga t = obj.toEntity();
		rep.save(t);
		String saida = "Dados atualizados com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/tipovaga")
	public ResponseEntity<String> delete(@Valid @RequestBody TipoVagaDTO obj) {
		TipoVaga t = obj.toEntity();
		System.out.println(t.getId());
		rep.delete(t);
		String saida = "Dados apagados com sucesso";
		return ResponseEntity.ok().body(saida);
	}

}
