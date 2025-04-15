package com.iurimedina.importacao_oferta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iurimedina.importacao_oferta.model.OfertaItem;

@Repository
public interface OfertaItemRepository extends JpaRepository<OfertaItem, Integer>{

}
