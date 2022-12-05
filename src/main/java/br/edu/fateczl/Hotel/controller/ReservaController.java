package br.edu.fateczl.Hotel.controller;

import java.math.BigInteger;
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
import br.edu.fateczl.Hotel.model.dto.ReservaDTO;
import br.edu.fateczl.Hotel.model.entity.Reserva;
import br.edu.fateczl.Hotel.repository.ReservaRepository;

@RestController
@RequestMapping("/api")
public class ReservaController extends Controller<ReservaDTO>{
	@Autowired
	ReservaRepository rep;
	
	@Override
	@GetMapping("/reserva")
	public List<ReservaDTO> findAll() {
		List<Reserva> reserva = rep.findAll();
		List<ReservaDTO> res =  new ArrayList<>();
		
		for(Reserva re: reserva) {
			res.add(re.toDTO());
		}
		
		return res;
	}

	@GetMapping("/reserva/{reservaId}")
	public ResponseEntity<ReservaDTO> findOne(@PathVariable(name="reservaId") BigInteger id) {
		Optional<Reserva> s = rep.findById(id);
		Reserva res = s.orElseThrow(()-> new ResourceNotFoundException(this.notFound("uma reserva",id+"")));
		return ResponseEntity.ok().body(res.toDTO());
	}
	
	@GetMapping("/reserva/{documento}/{tipodocumento}/{quartoid}/{dataInicio}")
	public ResponseEntity<ReservaDTO> findOne(@PathVariable(name="documento") String doc, 
												@PathVariable(name="tipodocumento") int tipoDoc,
												 @PathVariable(name="quartoid") BigInteger id, 
												 	@PathVariable(name="dataInicio") String dataInicio) {
		Optional<Reserva> s = rep.findById(id);
		Reserva res = s.orElseThrow(()-> new ResourceNotFoundException(this.notFound("um serviço",id+"")));
		return ResponseEntity.ok().body(res.toDTO());
	}
	
	@Override
	@PostMapping("/reserva/")
	public ResponseEntity<String> insert(@Valid @RequestBody ReservaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(1));
	}

	@Override
	@PutMapping("/reserva/")
	public ResponseEntity<String> update(@Valid @RequestBody ReservaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(2));
	}

	@Override
	@DeleteMapping("/reserva/")
	public ResponseEntity<String> delete(ReservaDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(this.sucesso(3));
	}

	@Override
	public ResponseEntity<ReservaDTO> findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}