package com.iurimedina.importacao_oferta.dto;

public class OfertaCSVDTO {
	
	private int numeroLinhaCSV;
    private String codigoBarras;
    private String preco;
    private String precoConnect;
    private String ativePague;
    private String qtdEncerrarOferta;
    private String qtdBloquearOferta;
    private String qtdLimitarOfertaConnect;
    private String prioridadeConnect;

    public OfertaCSVDTO(int numeroLinhaCSV, String codigoBarras, String preco, String precoConnect, String ativePague, String qtdEncerrarOferta, String qtdBloquearOferta, String qtdLimitarOfertaConnect, String prioridadeConnect) {
        this.numeroLinhaCSV = numeroLinhaCSV;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.precoConnect = precoConnect;
        this.ativePague = ativePague;
        this.qtdEncerrarOferta = qtdEncerrarOferta;
        this.qtdBloquearOferta = qtdBloquearOferta;
        this.qtdLimitarOfertaConnect = qtdLimitarOfertaConnect;
        this.prioridadeConnect = prioridadeConnect;
    }

	public int getNumeroLinhaCSV() {
		return numeroLinhaCSV;
	}

	public void setNumeroLinhaCSV(int numeroLinhaCSV) {
		this.numeroLinhaCSV = numeroLinhaCSV;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public String getPrecoConnect() {
		return precoConnect;
	}

	public void setPrecoConnect(String precoConnect) {
		this.precoConnect = precoConnect;
	}

	public String getAtivePague() {
		return ativePague;
	}

	public void setAtivePague(String ativePague) {
		this.ativePague = ativePague;
	}

	public String getQtdEncerrarOferta() {
		return qtdEncerrarOferta;
	}

	public void setQtdEncerrarOferta(String qtdEncerrarOferta) {
		this.qtdEncerrarOferta = qtdEncerrarOferta;
	}

	public String getQtdBloquearOferta() {
		return qtdBloquearOferta;
	}

	public void setQtdBloquearOferta(String qtdBloquearOferta) {
		this.qtdBloquearOferta = qtdBloquearOferta;
	}

	public String getQtdLimitarOfertaConnect() {
		return qtdLimitarOfertaConnect;
	}

	public void setQtdLimitarOfertaConnect(String qtdLimitarOfertaConnect) {
		this.qtdLimitarOfertaConnect = qtdLimitarOfertaConnect;
	}

	public String getPrioridadeConnect() {
		return prioridadeConnect;
	}

	public void setPrioridadeConnect(String prioridadeConnect) {
		this.prioridadeConnect = prioridadeConnect;
	}

	@Override
	public String toString() {
		return "OfertaCSVDTO [numeroLinhaCSV=" + numeroLinhaCSV + ", codigoBarras=" + codigoBarras + ", preco=" + preco
				+ ", precoConnect=" + precoConnect + ", ativePague=" + ativePague + ", qtdEncerrarOferta="
				+ qtdEncerrarOferta + ", qtdBloquearOferta=" + qtdBloquearOferta + ", qtdLimitarOfertaConnect="
				+ qtdLimitarOfertaConnect + ", prioridadeConnect=" + prioridadeConnect + "]";
	}



}
