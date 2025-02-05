package br.com.alura.screenmatch.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.alura.screenmatch.model.Categoria;
import br.com.alura.screenmatch.model.Serie;

public interface SerieRepository extends JpaRepository<Serie, Long> {
	 Optional<Serie> findByTituloContainingIgnoreCase(String nomeSerie);


	List<Serie> findByAtoresContainingIgnoreCaseAndAvaliacaoGreaterThanEqual(String nomeAtor, double avaliacao);

	List<Serie> findTop5ByOrderByAvaliacaoDesc();
	
	List<Serie> findByGenero(Categoria categoria);


	//Código omitido

	@Query("select s from Serie s WHERE s.totalTemporadas <= :totalTemporadas AND s.avaliacao >= :avaliacao")
	List<Serie> seriesPorTemporadaEAValiacao(int totalTemporadas, double avaliacao);

	//Código omitido
}
