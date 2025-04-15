package com.iurimedina.importacao_oferta.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iurimedina.importacao_oferta.model.TipoOferta;
import com.iurimedina.importacao_oferta.repository.TipoOfertaRepository;

@Service
@Transactional(readOnly = true)
public class TipoOfertaService {

	@Autowired
	private TipoOfertaRepository tipoOfertaRepository;
	
	public List<TipoOferta> listarTipoOfertas() {
		return tipoOfertaRepository.findAll();
	}
}
