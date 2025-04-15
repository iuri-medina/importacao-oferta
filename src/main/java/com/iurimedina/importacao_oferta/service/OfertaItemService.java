package com.iurimedina.importacao_oferta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iurimedina.importacao_oferta.model.OfertaItem;
import com.iurimedina.importacao_oferta.repository.OfertaItemRepository;

@Service
public class OfertaItemService {

	@Autowired
	private OfertaItemRepository ofertaItemRepository;
	
	public OfertaItem salvar(OfertaItem ofertaItem) {
		return ofertaItemRepository.save(ofertaItem);
	}
}
