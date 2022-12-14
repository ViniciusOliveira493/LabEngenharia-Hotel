package br.edu.fateczl.Hotel.controller.interfaces;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

public interface IController<T> {
	public List<T> findAll();
	public ResponseEntity<T> findOne(Integer id);
	public ResponseEntity<String> insert(@Valid @RequestBody T obj);
	public ResponseEntity<String> update(@Valid @RequestBody T obj);
	public ResponseEntity<String> delete(@Valid @RequestBody T obj);
}
