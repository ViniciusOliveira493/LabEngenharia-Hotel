package br.edu.fateczl.Hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.fateczl.Hotel.model.entity.Quarto;


public interface QuartoRepository extends JpaRepository<Quarto, Long>{
	@Query(
			value = "SELECT * FROM dbo.fn_buscarQuartosDisponiveis(?1,?2)"
			,nativeQuery = true
	)
	List<Quarto> buscarQuartosDisponiveis(String data,int tipo);
}
