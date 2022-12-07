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
import br.edu.fateczl.Hotel.model.dto.UnidadeDeMedidaDTO;
import br.edu.fateczl.Hotel.model.entity.UnidadeDeMedida;
import br.edu.fateczl.Hotel.repository.UnidadeDeMedidaRepository;

@RestController
@RequestMapping("/api")
public class UnidadeDeMedidaController extends Controller<UnidadeDeMedidaDTO>{
	@Autowired
	UnidadeDeMedidaRepository rep;
	
	@Override
	@GetMapping("/unidademedida/")
	public List<UnidadeDeMedidaDTO> findAll() {
		List<UnidadeDeMedida> lista = rep.findAll();
		List<UnidadeDeMedidaDTO> li = new ArrayList<>();
		
		for(UnidadeDeMedida med:lista) {
			li.add(med.toDTO());
		}
		
		return li;
	}

	@Override
	@GetMapping("/unidademedida/{id}")
	public ResponseEntity<UnidadeDeMedidaDTO> findOne(@PathVariable(name="id") Integer id) {
		Optional<UnidadeDeMedida> m = rep.findById(id);
		UnidadeDeMedida uniMedida = m.orElseThrow(()-> new ResourceNotFoundException(this.notFound("uma unidade de medida",id+"")));
		return ResponseEntity.ok().body(uniMedida.toDTO());
	}

	@Override
	@PostMapping("/unidademedida")
	public ResponseEntity<String> insert(@Valid @RequestBody UnidadeDeMedidaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(1));
	}

	@Override
	@PutMapping("/unidademedida")
	public ResponseEntity<String> update(@Valid @RequestBody UnidadeDeMedidaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(2));
	}

	@Override
	@DeleteMapping("/unidademedida")
	public ResponseEntity<String> delete(UnidadeDeMedidaDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(3));
	}

}
