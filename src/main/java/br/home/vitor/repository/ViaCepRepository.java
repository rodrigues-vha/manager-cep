package br.home.vitor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.home.vitor.model.ViaCepModel;

@Repository
public interface ViaCepRepository extends JpaRepository<ViaCepModel, Long> {
	
	@Query("SELECT c.uf FROM ViaCepModel c GROUP BY c.uf ORDER BY COUNT(c.uf) DESC LIMIT 1")
	public String EstadoMaisAcessado();
}
