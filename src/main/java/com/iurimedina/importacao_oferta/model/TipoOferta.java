package com.iurimedina.importacao_oferta.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipooferta")
public class TipoOferta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(nullable = false)
	private String descricao;
	
	
	
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

		@Override
		public String toString() {
			return descricao;
		}		

}
