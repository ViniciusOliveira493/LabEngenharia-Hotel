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
import br.edu.fateczl.Hotel.model.dto.TipoQuartoDTO;
import br.edu.fateczl.Hotel.model.entity.TipoQuarto;
import br.edu.fateczl.Hotel.repository.TipoQuartoRepository;

@RestController
@RequestMapping("/api")
public class TipoQuartoController extends Controller<TipoQuartoDTO>{
	@Autowired
	TipoQuartoRepository rep;
	
	@Override
	@GetMapping("/tipoquarto")
	public List<TipoQuartoDTO> findAll() {
		List<TipoQuarto> quartos = rep.findAll();
		List<TipoQuartoDTO> qtDTO = new ArrayList<>();
		
		for(TipoQuarto tq:quartos) {
			qtDTO.add(tq.toDTO());
		}
		return qtDTO;
	}

	@GetMapping("/tipoquarto/{tipo}")
	public ResponseEntity<TipoQuartoDTO> findOne(@PathVariable(name="tipo") String id) {
		Optional<TipoQuarto> tipo = rep.findById(id);
		TipoQuarto q = tipo.orElseThrow(()-> new ResourceNotFoundException(notFound("um quarto do tipo" , id+ "")));
		return ResponseEntity.ok().body(q.toDTO());
	}

	@Override
	@PostMapping("/tipoquarto")
	public ResponseEntity<String> insert(@Valid @RequestBody TipoQuartoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(1));
	}

	@Override
	@PutMapping("/tipoquarto")
	public ResponseEntity<String> update(@Valid @RequestBody TipoQuartoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(2));
	}

	@Override
	@DeleteMapping("/tipoquarto")
	public ResponseEntity<String> delete(@Valid @RequestBody TipoQuartoDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(3));
	}

	@Override
	public ResponseEntity<TipoQuartoDTO> findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}