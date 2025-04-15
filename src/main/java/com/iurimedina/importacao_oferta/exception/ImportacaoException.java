package com.iurimedina.importacao_oferta.exception;

public class ImportacaoException extends Exception {

	private static final long serialVersionUID = 1L;

	public ImportacaoException() {
        super();
    }

    public ImportacaoException(String message) {
        super(message);
    }

    public ImportacaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImportacaoException(Throwable cause) {
        super(cause);
    }

    // Opcional: Se quiser adicionar campos adicionais para mais informações sobre o erro
    private Integer linhaCsv;
    private String codigoBarras;

    public ImportacaoException(String message, Integer linhaCsv, String codigoBarras) {
        super(message);
        this.linhaCsv = linhaCsv;
        this.codigoBarras = codigoBarras;
    }

    // Getters para os campos adicionais
    public Integer getLinhaCsv() {
        return linhaCsv;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }
}