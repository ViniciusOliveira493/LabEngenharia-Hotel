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
import br.edu.fateczl.Hotel.model.dto.QuartoDTO;
import br.edu.fateczl.Hotel.model.entity.Quarto;
import br.edu.fateczl.Hotel.model.entity.QuartoID;
import br.edu.fateczl.Hotel.model.entity.TipoQuarto;
import br.edu.fateczl.Hotel.repository.QuartoRepository;

@RestController
@RequestMapping("/api")
public class QuartoController extends Controller<QuartoDTO>{
	@Autowired
	QuartoRepository rep;
	
	@Override
	@GetMapping("/quartos/")
	public List<QuartoDTO> findAll() {
		List<Quarto> quartos = rep.findAll();
		List<QuartoDTO> qt = new ArrayList<>();
		
		for(Quarto q:quartos) {
			qt.add(q.toDTO());
		}
		return qt;
	}

	@GetMapping("/quartos/{id}")
	public ResponseEntity<QuartoDTO> findOne(@PathVariable(name="id") Integer i) {
		QuartoID id = new QuartoID();
		id.setQuarto(i);
		Optional<Quarto> quarto = rep.findById(id);
		Quarto q = quarto.orElseThrow(()-> new ResourceNotFoundException(notFound("um quarto do tipo" , i+ "")));
		return ResponseEntity.ok().body(q.toDTO());
	}

	@Override
	@PostMapping("/quartos")
	public ResponseEntity<String> insert(@Valid @RequestBody QuartoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(1));
	}

	@Override
	@PutMapping("/quartos")
	public ResponseEntity<String> update(@Valid @RequestBody QuartoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(2));
	}

	@Override
	@DeleteMapping("/quartos")
	public ResponseEntity<String> delete(@Valid @RequestBody QuartoDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(3));
	}
	
}