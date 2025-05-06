package com.iurimedina.importacao_oferta.model;

public class CheckResult {

	private boolean valido;
	private Integer valor;
	
	public CheckResult(boolean valido, Integer valor) {
		super();
		this.valido = valido;
		this.valor = valor;
	}
	
	public boolean isValido() {
		return valido;
	}
	public Integer getValor() {
		return valor;
	}
}
