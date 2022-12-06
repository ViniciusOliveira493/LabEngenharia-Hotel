package br.edu.fateczl.Hotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.fateczl.Hotel.model.entity.Vaga;
import br.edu.fateczl.Hotel.model.entity.VagaId;

public interface VagaRepository extends JpaRepository<Vaga, VagaId>{
	@Query(
			value = "SELECT * FROM dbo.fn_buscarVagasDisponiveis(?1,?2)"
			,nativeQuery = true
	)
	public List<Vaga> buscarDisponiveis(String data,int tipo); 
}
