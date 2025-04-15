package com.iurimedina.importacao_oferta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "produto")
public class Produto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "descricaocompleta")
    private String descricaoCompleta;
    
    public Produto(Integer id) {
    	this.id = id;
    }
    
    // Getters e Setters
    public Integer getId() {
        return id;
    }
    
    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }
}
