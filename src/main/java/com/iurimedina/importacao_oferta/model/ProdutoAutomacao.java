package com.iurimedina.importacao_oferta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produtoautomacao")
public class ProdutoAutomacao {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "codigobarras")
    private Long codigoBarras;
    
    @Column(name = "id_produto")
    private Integer idProduto;
    
    public ProdutoAutomacao() {
    }
    
    public Long getId() {
        return id;
    }
    
    public Long getCodigoBarras() {
        return codigoBarras;
    }
    
    public Integer getIdProduto() {
        return idProduto;
    }
}
