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
import br.edu.fateczl.Hotel.model.dto.TipoDocumentoDTO;
import br.edu.fateczl.Hotel.model.entity.TipoDocumento;
import br.edu.fateczl.Hotel.repository.TipoDocumentoRepository;

@RestController
@RequestMapping("/api")
public class TipoDocumentoController implements Controller<TipoDocumentoDTO>{
	@Autowired
	TipoDocumentoRepository rep;

	@Override
	@GetMapping("/tipodocumento")
	public List<TipoDocumentoDTO> findAll() {
		List<TipoDocumento> lista = rep.findAll();
		List<TipoDocumentoDTO> l = new ArrayList<>();
		
		for(TipoDocumento doc:lista) {
			l.add(doc.toDTO());
		}
		
		return l;
	}
	
	@Override
	@GetMapping("/tipodocumento/{id}")
	public ResponseEntity<TipoDocumentoDTO> findOne(@PathVariable(value="id") Integer id) {
		Optional<TipoDocumento> tipo = rep.findById(id);
		TipoDocumento t = tipo.orElseThrow(()->new ResourceNotFoundException("Código inválido"));
		return ResponseEntity.ok().body(t.toDTO());
	}

	@Override
	@PostMapping("/tipodocumento/")
	public ResponseEntity<String> insert(@Valid @RequestBody TipoDocumentoDTO obj) {
		TipoDocumento tipo = obj.toEntity();
		rep.save(tipo);
		String saida = "Dados cadastrados com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@PutMapping("/tipodocumento/")
	public ResponseEntity<String> update(@Valid @RequestBody TipoDocumentoDTO obj) {
		TipoDocumento tipo = obj.toEntity();
		rep.save(tipo);
		String saida = "Dados atualizados com sucesso";
		return ResponseEntity.ok().body(saida);
	}

	@Override
	@DeleteMapping("/tipodocumento/")
	public ResponseEntity<String> delete(@Valid @RequestBody TipoDocumentoDTO obj) {
		TipoDocumento tipo = obj.toEntity();
		rep.delete(tipo);
		String saida = "Dados apagados com sucesso";
		return ResponseEntity.ok().body(saida);
	}
	
	
}
