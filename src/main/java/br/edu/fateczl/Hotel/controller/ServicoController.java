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
import br.edu.fateczl.Hotel.model.dto.ServicoDTO;
import br.edu.fateczl.Hotel.model.entity.Servico;
import br.edu.fateczl.Hotel.repository.ServicoRepository;

@RestController
@RequestMapping("/api")
public class ServicoController extends Controller<ServicoDTO>{
	@Autowired
	ServicoRepository rep;
	
	@Override
	@GetMapping("/servico/")
	public List<ServicoDTO> findAll() {
		List<Servico> lista = rep.findAll();
		List<ServicoDTO> li = new ArrayList<>();
		
		for(Servico ser:lista) {
			li.add(ser.toDTO());
		}
		
		return li;
	}

	@Override
	@GetMapping("/servico/{id}")
	public ResponseEntity<ServicoDTO> findOne(@PathVariable(name="id") Integer id) {
		Optional<Servico> s = rep.findById(id);
		Servico serv = s.orElseThrow(()-> new ResourceNotFoundException(this.notFound("um serviço",id+"")));
		return ResponseEntity.ok().body(serv.toDTO());
	}

	@Override
	@PostMapping("/servico")
	public ResponseEntity<String> insert(@Valid @RequestBody ServicoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(1));
	}

	@Override
	@PutMapping("/servico")
	public ResponseEntity<String> update(@Valid @RequestBody ServicoDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(2));
	}

	@Override
	@DeleteMapping("/servico")
	public ResponseEntity<String> delete(ServicoDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(3));
	}

}
