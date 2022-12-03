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
import br.edu.fateczl.Hotel.model.dto.VagaDTO;
import br.edu.fateczl.Hotel.model.entity.Vaga;
import br.edu.fateczl.Hotel.model.entity.VagaId;
import br.edu.fateczl.Hotel.repository.VagaRepository;
import br.edu.fateczl.Hotel.repository.VagasCustom.RepCustomVagas;

@RestController
@RequestMapping("/api")
public class VagaController extends Controller<VagaDTO>{
	@Autowired
	VagaRepository rep;
	
	RepCustomVagas repc = new RepCustomVagas();
	
	@GetMapping("/vagas/{estacionamento}")
	public List<VagaDTO> findByEstacionamento(@PathVariable(name="estacionamento") String a) {
		List<VagaDTO> vagas = repc.findVagasPorEstacionamento(a);
		return vagas;
	}
	
	@Override
	@GetMapping("/vagas/")
	public List<VagaDTO> findAll() {
		List<Vaga> vagas = rep.findAll();
		List<VagaDTO> va = new ArrayList<>();
		
		for(Vaga v:vagas) {
			va.add(v.toDTO());
		}
		return va;
	}
	
	@GetMapping("/vagas/{id}/{estacionamento}")
	public ResponseEntity<VagaDTO> findOne(@PathVariable(name="estacionamento") String a,@PathVariable(name="id") Integer e) {
		VagaId id = new VagaId();
		id.setEstacionamento(a);
		id.setNumVaga(e);
		Optional<Vaga> vaga = rep.findById(id);
		Vaga v = vaga.orElseThrow(()-> new ResourceNotFoundException(notFound("uma vaga no estacionamento "+a, e+"")));
		return ResponseEntity.ok().body(v.toDTO());
	}

	@Override
	@PostMapping("/vagas")
	public ResponseEntity<String> insert(@Valid @RequestBody VagaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(1));
	}

	@Override
	@PutMapping("/vagas")
	public ResponseEntity<String> update(@Valid @RequestBody VagaDTO obj) {
		rep.save(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(2));
	}

	@Override
	@DeleteMapping("/vagas")
	public ResponseEntity<String> delete(@Valid @RequestBody VagaDTO obj) {
		rep.delete(obj.toEntity());
		return ResponseEntity.ok().body(sucesso(3));
	}

	@Override
	public ResponseEntity<VagaDTO> findOne(Integer a) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
