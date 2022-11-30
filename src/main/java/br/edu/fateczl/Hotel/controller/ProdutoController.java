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
import br.edu.fateczl.Hotel.model.dto.ProdutoDTO;
import br.edu.fateczl.Hotel.model.entity.Produto;
import br.edu.fateczl.Hotel.repository.ProdutoRepository;

@RestController
@RequestMapping("/api")
public class ProdutoController extends Controller<ProdutoDTO>{

		@Autowired
		ProdutoRepository rep;
		
		@Override
		@GetMapping("/produtos/")
		public List<ProdutoDTO> findAll() {
			List<Produto> produtos = rep.findAll();
			List<ProdutoDTO> pd = new ArrayList<>();
			
			for(Produto p:produtos) {
				pd.add(p.toDTO());
			}
			return pd;
		}

		@Override
		@GetMapping("/produtos/{codigo}")
		public ResponseEntity<ProdutoDTO> findOne(@PathVariable(name="codigo") Integer codigo) {
			Optional<Produto> p = rep.findById(codigo);
			Produto prod = p.orElseThrow(()-> new ResourceNotFoundException(this.notFound("um produto",codigo+"")));
			return ResponseEntity.ok().body(prod.toDTO());
		}

		@Override
		@PostMapping("/produtos")
		public ResponseEntity<String> insert(@Valid @RequestBody ProdutoDTO obj) {
			rep.save(obj.toEntity());
			return ResponseEntity.ok().body(sucesso(1));
		}

		@Override
		@PutMapping("/produtos")
		public ResponseEntity<String> update(@Valid @RequestBody ProdutoDTO obj) {
			rep.save(obj.toEntity());
			return ResponseEntity.ok().body(sucesso(2));
		}

		@Override
		@DeleteMapping("/produtos")
		public ResponseEntity<String> delete(@Valid @RequestBody ProdutoDTO obj) {
			rep.delete(obj.toEntity());
			return ResponseEntity.ok().body(sucesso(3));
		}

		
	}



