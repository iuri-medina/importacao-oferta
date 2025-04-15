package com.iurimedina.importacao_oferta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.iurimedina.importacao_oferta.model.Oferta;

public interface OfertaRepository extends JpaRepository<Oferta, Integer>{

	@Query(value = "SELECT id FROM simulacaooferta ORDER BY id DESC LIMIT 1", nativeQuery = true)
	int findMaxIdOferta();
}
