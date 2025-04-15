package com.iurimedina.importacao_oferta.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.iurimedina.importacao_oferta.dto.ProdutoInfoDTO;
import com.iurimedina.importacao_oferta.model.ProdutoAutomacao;

@Repository
public interface ProdutoAutomacaoRepository extends JpaRepository<ProdutoAutomacao, Integer>{

	@Query(value = "SELECT p.id, p.descricaocompleta, CAST(pc.precovenda AS DECIMAL(10,2)), CAST(pc.custocomimposto AS DECIMAL(10,2)), " +
	        "CASE WHEN pc.precovenda = 0 THEN 0 ELSE ROUND(((pc.precovenda - (pc.precovenda * (a.porcentagemfinal / 100)) - " +
	        "(pc.precovenda * (((tp.valorpis - (tp.valorpis * tp.reduzidocredito / 100)) + " +
	        "(tp.valorcofins - (tp.valorcofins * tp.reduzidocredito / 100))) / 100)) - " +
	        "(pc.precovenda) * ((SELECT CAST(REPLACE(valor, ',', '.') AS NUMERIC) FROM parametrovalor " +
	        "WHERE id_parametro = 96 AND id_loja = l.id) / 100) - " +
	        "(pc.precovenda * (pc.operacional / 100)) - pc.custosemimposto) / pc.precovenda * 100), 2) END, " +
	        "CASE WHEN pc.precovenda = 0 THEN 0 ELSE ROUND(((pc.precovenda * (100 - a.porcentagemfinal - " +
	        "((tp.valorpis - (tp.valorpis * tp.reduzidocredito / 100)) + " +
	        "(tp.valorcofins - (tp.valorcofins * tp.reduzidocredito / 100))) - " +
	        "(SELECT CAST(REPLACE(valor, ',', '.') AS NUMERIC) FROM parametrovalor " +
	        "WHERE id_parametro = 96 AND id_loja = l.id)) / 100) - pc.custosemimposto) / pc.precovenda * 100, 2) END, " +
	        "ROUND(CASE WHEN pc.precovenda = 0 OR pc.custocomimposto = 0 THEN 0 ELSE ((pc.precovenda / pc.custocomimposto) * 100) - 100 END, 2), " +
	        "ROUND(CASE WHEN pc.precovenda = 0 THEN 0 ELSE (100 - ((pc.custocomimposto / pc.precovenda) * 100)) END, 2), " +
	        "CAST(pc.custosemimposto AS DECIMAL(10,2)), a.porcentagem, (tp.valorpis + tp.valorcofins) " +
	        "FROM produto p " +
	        "INNER JOIN loja l ON l.id = :loja " +
	        "INNER JOIN fornecedor f ON f.id = l.id_fornecedor " +
	        "INNER JOIN produtoaliquota pa ON pa.id_produto = p.id AND pa.id_estado = f.id_estado " +
	        "INNER JOIN aliquota a ON a.id = pa.id_aliquotaconsumidor AND pa.id_estado = f.id_estado " +
	        "INNER JOIN tipopiscofins tp ON tp.id = p.id_tipopiscofins " +
	        "LEFT JOIN tipoembalagem te ON te.id = p.id_tipoembalagem " +
	        "LEFT JOIN produtocomplemento pc ON pc.id_produto = p.id AND pc.id_loja = l.id " +
	        "LEFT JOIN produtoautomacao pau ON p.id = pau.id_produto " +
	        "WHERE pc.id_situacaocadastro = 1 AND pau.codigobarras = :codigoBarras;", nativeQuery = true)
	Optional<ProdutoInfoDTO> findProdutoByCodigoBarras(@Param("codigoBarras") Long codigobarras, @Param("loja") Integer idLoja);
}
