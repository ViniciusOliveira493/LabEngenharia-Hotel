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
import br.edu.fateczl.Hotel.repository.reservaCustom.ReservaCustomRep;

@RestController
@RequestMapping("/api")
public class ReservaController extends Controller<ReservaDTO>{
	@Autowired
	ReservaRepository rep;
	
	ReservaCustomRep rcr = new ReservaCustomRep();
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
	
	@GetMapping("/reserva/{documento}/{tipodocumento}/{dataInicio}")
	public List<ReservaDTO> findData(@PathVariable(name="documento") String doc, 
												@PathVariable(name="tipodocumento") int tipoDoc, 
												 	@PathVariable(name="dataInicio") String dataInicio) {
		List<Reserva> reserva = rep.buscarDisponiveis(tipoDoc, doc, dataInicio);
		List<ReservaDTO> res =  new ArrayList<>();
		
		for(Reserva re: reserva) {
			res.add(re.toDTO());
		}		
		return res;
	}
	
	@Override
	@PostMapping("/reserva")
	public ResponseEntity<String> insert(@Valid @RequestBody ReservaDTO obj) {
		System.err.println(obj.toString());
		rcr.criarReserva(obj);
		return ResponseEntity.ok().body(this.sucesso(1));
	}

	@Override
	@PutMapping("/reserva")
	public ResponseEntity<String> update(@Valid @RequestBody ReservaDTO obj) {
		return ResponseEntity.ok().body("A atualização não é permitida para reservas");
	}

	@Override
	@DeleteMapping("/reserva")
	public ResponseEntity<String> delete(ReservaDTO obj) {
		rcr.cancelarReserva(obj);
		return ResponseEntity.ok().body(this.sucesso(3));
	}

	@Override
	public ResponseEntity<ReservaDTO> findOne(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}


}