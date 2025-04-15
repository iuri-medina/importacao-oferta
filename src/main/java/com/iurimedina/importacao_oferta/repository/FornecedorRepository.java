package com.iurimedina.importacao_oferta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.iurimedina.importacao_oferta.dto.FornecedorDto;
import com.iurimedina.importacao_oferta.model.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Long>{

	@Query(value = "SELECT f.cnpj FROM fornecedor f INNER JOIN loja l ON f.id = l.id_fornecedor WHERE l.servidorcentral = true", nativeQuery = true)
	FornecedorDto findCnpj(); 
}
