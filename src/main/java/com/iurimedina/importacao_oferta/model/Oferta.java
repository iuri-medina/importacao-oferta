package com.iurimedina.importacao_oferta.model;

import java.time.LocalDate;

import jakarta.persistence.*;

@Entity
@Table(name = "simulacaooferta")
public class Oferta {

	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String descricao;
	
	@Column(nullable = false)
	private LocalDate data;

	
	//getters e setters
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Oferta [id=" + id + ", descricao=" + descricao + ", data=" + data + "]";
	}

	
}
