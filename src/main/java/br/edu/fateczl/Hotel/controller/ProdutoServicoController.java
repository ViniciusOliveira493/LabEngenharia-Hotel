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
import br.edu.fateczl.Hotel.model.dto.ProdutoServicoDTO;
import br.edu.fateczl.Hotel.model.entity.ProdutoServico;
import br.edu.fateczl.Hotel.model.entity.ProdutoServicoID;
import br.edu.fateczl.Hotel.repository.ProdutoServicoRepository;
import br.edu.fateczl.Hotel.repository.pscr.ProdutoServicoCustomRepository;

@RestController
@RequestMapping("/api")
public class ProdutoServicoController{
	@Autowired
	ProdutoServicoRepository rep;	
	
	ProdutoServicoCustomRepository pscr = new ProdutoServicoCustomRepository();
	@GetMapping("/produtoservico/{idServico}")
	public List<ProdutoServicoDTO> findAll(@PathVariable(name="idServico") BigInteger id) {
		List<ProdutoServico> produtoservico = pscr.find(id);
		List<ProdutoServicoDTO> prse = new ArrayList<>();
		
		for(ProdutoServico ps:produtoservico) {
			prse.add(ps.toDTO());
		}
		return prse;
	}

	
	@PostMapping("/produtoservico")
	public ResponseEntity<String> insert(@Valid @RequestBody ProdutoServicoDTO obj) {
		pscr.cadastrar(obj);
		return ResponseEntity.ok().body("Cadastrado");
	}

	
	@DeleteMapping("/produtoservico")
	public ResponseEntity<String> delete(@Valid @RequestBody ProdutoServicoDTO obj) {
		pscr.apagarTd(obj);
		return ResponseEntity.ok().body("Apagado com sucesso");
	}		
}



