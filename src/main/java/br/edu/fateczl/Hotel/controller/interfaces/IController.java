package br.edu.fateczl.Hotel.controller.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import br.edu.fateczl.Hotel.model.dto.UnidadeDeMedidaDTO;
import br.edu.fateczl.Hotel.model.dto.interfaces.IDTO;
import br.edu.fateczl.Hotel.model.entity.interfaces.IEntity;

public interface IController<T> {
	public List<T> findAll();
	public ResponseEntity<T> findOne(Integer a);
	public ResponseEntity<String> insert(@Valid @RequestBody T obj);
	public ResponseEntity<String> update(@Valid @RequestBody T obj);
	public ResponseEntity<String> delete(@Valid @RequestBody T obj);
		
}
