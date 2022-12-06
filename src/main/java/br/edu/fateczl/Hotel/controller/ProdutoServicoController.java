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
import br.edu.fateczl.Hotel.model.dto.ProdutoServicoDTO;
import br.edu.fateczl.Hotel.model.entity.ProdutoServico;
import br.edu.fateczl.Hotel.model.entity.ProdutoServicoID;
import br.edu.fateczl.Hotel.repository.ProdutoServicoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoServicoController extends Controller<ProdutoServicoDTO>{

		@Autowired
		ProdutoServicoRepository rep;
		
		@Override
		@GetMapping("/produtoservico")
		public List<ProdutoServicoDTO> findAll() {
			List<ProdutoServico> produtoservico = rep.findAll();
			List<ProdutoServicoDTO> prse = new ArrayList<>();
			
			for(ProdutoServico ps:produtoservico) {
				prse.add(ps.toDTO());
			}
			return prse;
		}

		@GetMapping("/produtoservico/{codigo}/{id}")
		public ResponseEntity<ProdutoServicoDTO> findOne(@PathVariable(name="codigo") Integer p,@PathVariable(name="id") Integer s) {
			ProdutoServicoID id = new ProdutoServicoID();
			id.setCodigo(p);
			id.setId(s);
			Optional<ProdutoServico> prsv = rep.findById(id);
			ProdutoServico ps = prsv.orElseThrow(()-> new ResourceNotFoundException(notFound("um produto no serviço "+p, s+"")));
			return ResponseEntity.ok().body(ps.toDTO());
		}

		@Override
		@PostMapping("/produtoservico")
		public ResponseEntity<String> insert(@Valid @RequestBody ProdutoServicoDTO obj) {
			rep.save(obj.toEntity());
			return ResponseEntity.ok().body(sucesso(1));
		}

		@Override
		@PutMapping("/produtoservico")
		public ResponseEntity<String> update(@Valid @RequestBody ProdutoServicoDTO obj) {
			rep.save(obj.toEntity());
			return ResponseEntity.ok().body(sucesso(2));
		}

		@Override
		@DeleteMapping("/produtoservico")
		public ResponseEntity<String> delete(@Valid @RequestBody ProdutoServicoDTO obj) {
			rep.delete(obj.toEntity());
			return ResponseEntity.ok().body(sucesso(3));
		}

		@Override
		public ResponseEntity<ProdutoServicoDTO> findOne(Integer a) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}



