package com.iurimedina.importacao_oferta.dto;

import java.math.BigDecimal;

public class ProdutoInfoDTO {

	private Integer idProduto;
	private String descricaoCompleta;
	private BigDecimal precoVenda;
	private BigDecimal custoComImposto;
	private BigDecimal margemLiquida;
	private BigDecimal margemBruta;
	private BigDecimal margemSbCusto;
	private BigDecimal margemSbVenda;
	private BigDecimal custoSemImposto;
	private BigDecimal icmsDebito;
	private BigDecimal pisCofinsDebito;
	
	

	public ProdutoInfoDTO(Integer idProduto, String descricaoCompleta, BigDecimal precoVenda,
			BigDecimal custoComImposto, BigDecimal margemLiquida, BigDecimal margemBruta, BigDecimal margemSbCusto,
			BigDecimal margemSbVenda, BigDecimal custoSemImposto, BigDecimal icmsDebito, BigDecimal pisCofinsDebito) {
		super();
		this.idProduto = idProduto;
		this.descricaoCompleta = descricaoCompleta;
		this.precoVenda = precoVenda;
		this.custoComImposto = custoComImposto;
		this.margemLiquida = margemLiquida;
		this.margemBruta = margemBruta;
		this.margemSbCusto = margemSbCusto;
		this.margemSbVenda = margemSbVenda;
		this.custoSemImposto = custoSemImposto;
		this.icmsDebito = icmsDebito;
		this.pisCofinsDebito = pisCofinsDebito;
	}



	public Integer getIdProduto() {
		return idProduto;
	}



	public String getDescricaoCompleta() {
		return descricaoCompleta;
	}



	public BigDecimal getPrecoVenda() {
		return precoVenda;
	}



	public BigDecimal getCustoComImposto() {
		return custoComImposto;
	}



	public BigDecimal getMargemLiquida() {
		return margemLiquida;
	}



	public BigDecimal getMargemBruta() {
		return margemBruta;
	}



	public BigDecimal getMargemSbCusto() {
		return margemSbCusto;
	}



	public BigDecimal getMargemSbVenda() {
		return margemSbVenda;
	}



	public BigDecimal getCustoSemImposto() {
		return custoSemImposto;
	}



	public BigDecimal getIcmsDebito() {
		return icmsDebito;
	}



	public BigDecimal getPisCofinsDebito() {
		return pisCofinsDebito;
	}

	
	
	
}
