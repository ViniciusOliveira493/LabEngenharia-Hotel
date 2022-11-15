package br.edu.fateczl.Hotel.controller.interfaces;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface Controller<T> {
	public List<T> findAll();
	public ResponseEntity<T> findOne(Integer a);
	public ResponseEntity<String> insert(T obj);
	public ResponseEntity<String> update(T obj);
	public ResponseEntity<String> delete(T obj);	
}
