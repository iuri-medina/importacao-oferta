package com.iurimedina.importacao_oferta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iurimedina.importacao_oferta.model.Loja;
import com.iurimedina.importacao_oferta.repository.LojaRepository;

@Service
@Transactional(readOnly = true)
public class LojaService {
	
	@Autowired
	private LojaRepository lojaRepository;
	
	public List<Loja> listarLojas() {
		return lojaRepository.findAll();
	}
}
