package com.iurimedina.importacao_oferta.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iurimedina.importacao_oferta.model.OfertaItemConnect;
import com.iurimedina.importacao_oferta.repository.OfertaItemConnectRepository;

@Service
public class OfertaItemConnectService {

	@Autowired
	private OfertaItemConnectRepository ofertaItemConnectRepository;
	
	public OfertaItemConnect salvar(OfertaItemConnect ofertaItemConnect) {
		return ofertaItemConnectRepository.save(ofertaItemConnect);
	}
}
