package com.iurimedina.importacao_oferta.dto;

public class OfertaCSVDTO {
	
	private int numeroLinhaCSV;
    private String codigoBarras;
    private String preco;
    private String connect;
    private String precoConnect;
    private String ativePague;

    public OfertaCSVDTO(int numeroLinhaCSV, String codigoBarras, String preco, String connect, String precoConnect, String ativePague) {
        this.numeroLinhaCSV = numeroLinhaCSV;
        this.codigoBarras = codigoBarras;
        this.preco = preco;
        this.connect = connect;
        this.precoConnect = precoConnect;
        this.ativePague = ativePague;
    }

	public String getAtivePague() {
		return ativePague;
	}

	public void setAtivePague(String ativePague) {
		this.ativePague = ativePague;
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

	public String getConnect() {
		return connect;
	}

	public void setConnect(String connect) {
		this.connect = connect;
	}

	public String getPrecoConnect() {
		return precoConnect;
	}

	public void setPrecoConnect(String precoConnect) {
		this.precoConnect = precoConnect;
	}

	@Override
	public String toString() {
		return "OfertaCSVDTO [numeroLinhaCSV=" + numeroLinhaCSV + ", codigoBarras=" + codigoBarras + ", preco=" + preco
				+ ", connect=" + connect + ", precoConnect=" + precoConnect + ", ativePague=" + ativePague + "]";
	}

	

}
