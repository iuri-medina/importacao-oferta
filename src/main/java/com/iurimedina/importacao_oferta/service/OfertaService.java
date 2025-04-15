package com.iurimedina.importacao_oferta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iurimedina.importacao_oferta.model.Oferta;
import com.iurimedina.importacao_oferta.repository.OfertaRepository;

@Service
@Transactional()
public class OfertaService {

	@Autowired
	private OfertaRepository ofertaRepository;
	
	public List<Oferta> listarOfertas() {
		return ofertaRepository.findAll();
	}
	
	public Oferta salvar(Oferta oferta) {
		return ofertaRepository.save(oferta);
	}
}
