package com.iurimedina.importacao_oferta.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "simulacaoofertaitem")
public class OfertaItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_produto")
    private Integer idProduto;

    @Column(name = "custocomimposto", precision = 19, scale = 4)
    private BigDecimal custoComImposto = BigDecimal.valueOf(0);

    @Column(name = "preconormal", precision = 19, scale = 4)
    private BigDecimal precoNormal;

    @Column(name = "precooferta", precision = 19, scale = 4)
    private BigDecimal precoOferta;

    @Column(name = "margemliquida", precision = 19, scale = 4)
    private BigDecimal margemLiquida = BigDecimal.valueOf(0);

    @Column(name = "margemliquidaoferta", precision = 19, scale = 4)
    private BigDecimal margemLiquidaOferta = BigDecimal.valueOf(0);

    @Column(name = "margembruta", precision = 19, scale = 4)
    private BigDecimal margemBruta = BigDecimal.valueOf(0);

    @Column(name = "margembrutaoferta", precision = 19, scale = 4)
    private BigDecimal margemBrutaOferta = BigDecimal.valueOf(0);

    @Column(name = "margemsbcusto", precision = 19, scale = 4)
    private BigDecimal margemSbCusto = BigDecimal.valueOf(0);

    @Column(name = "margemsbcustooferta", precision = 19, scale = 4)
    private BigDecimal margemSbCustoOferta = BigDecimal.valueOf(0);

    @Column(name = "margemsbvenda", precision = 19, scale = 4)
    private BigDecimal margemSbVenda = BigDecimal.valueOf(0);

    @Column(name = "margemsbvendaoferta", precision = 19, scale = 4)
    private BigDecimal margemSbVendaOferta = BigDecimal.valueOf(0);

    @Column(name = "quantidade", precision = 19, scale = 4)
    private BigDecimal quantidade = BigDecimal.valueOf(0);

    @Column(name = "lucro", precision = 19, scale = 4)
    private BigDecimal lucro = BigDecimal.valueOf(0);

    @ManyToOne
    @JoinColumn(name = "id_simulacaooferta")
    private Oferta oferta;

    @ManyToOne
    @JoinColumn(name = "id_tipooferta")
    private TipoOferta tipoOferta;

    @Column(name = "encerraoferta")
    private Boolean encerraOferta = false;

    @Column(name = "encerraofertaitens")
    private Integer encerraOfertaItens = 0;

    @Column(name = "bloquearoferta")
    private Boolean bloquearOferta = false;

    @Column(name = "bloquearofertaitens", precision = 19, scale = 4)
    private BigDecimal bloquearOfertaItens = BigDecimal.valueOf(0);

    @Column(name = "enviaconnect")
    private Boolean enviaConnect;

    @Column(name = "fatorexclusaoicms", precision = 19, scale = 4)
    private BigDecimal fatorExclusaoIcms = BigDecimal.valueOf(0);

    @Column(name = "custosemimposto", precision = 19, scale = 4)
    private BigDecimal custoSemImposto = BigDecimal.valueOf(0);

    @Column(name = "custosemimpostooferta", precision = 19, scale = 4)
    private BigDecimal custoSemImpostoOferta = BigDecimal.valueOf(0);

    @Column(name = "custocomimpostooferta", precision = 19, scale = 4)
    private BigDecimal custoComImpostoOferta = BigDecimal.valueOf(0);

    @Column(name = "icmsdebito", precision = 19, scale = 4)
    private BigDecimal icmsDebito = BigDecimal.valueOf(0);

    @Column(name = "valoradicional", precision = 19, scale = 4)
    private BigDecimal valorAdicional = BigDecimal.valueOf(0);

    @Column(name = "piscofinsdebito", precision = 19, scale = 4)
    private BigDecimal pisCofinsDebito = BigDecimal.valueOf(0);

    @Column(name = "operacional", precision = 19, scale = 4)
    private BigDecimal operacional = BigDecimal.valueOf(0);

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public BigDecimal getCustoComImposto() {
        return custoComImposto;
    }

    public void setCustoComImposto(BigDecimal custoComImposto) {
        this.custoComImposto = custoComImposto;
    }

	public BigDecimal getPrecoNormal() {
		return precoNormal;
	}

	public void setPrecoNormal(BigDecimal precoNormal) {
		this.precoNormal = precoNormal;
	}

	public BigDecimal getPrecoOferta() {
		return precoOferta;
	}

	public void setPrecoOferta(BigDecimal precoOferta) {
		this.precoOferta = precoOferta;
	}

	public BigDecimal getMargemLiquida() {
		return margemLiquida;
	}

	public void setMargemLiquida(BigDecimal margemLiquida) {
		this.margemLiquida = margemLiquida;
	}

	public BigDecimal getMargemLiquidaOferta() {
		return margemLiquidaOferta;
	}

	public void setMargemLiquidaOferta(BigDecimal margemLiquidaOferta) {
		this.margemLiquidaOferta = margemLiquidaOferta;
	}

	public BigDecimal getMargemBruta() {
		return margemBruta;
	}

	public void setMargemBruta(BigDecimal margemBruta) {
		this.margemBruta = margemBruta;
	}

	public BigDecimal getMargemBrutaOferta() {
		return margemBrutaOferta;
	}

	public void setMargemBrutaOferta(BigDecimal margemBrutaOferta) {
		this.margemBrutaOferta = margemBrutaOferta;
	}

	public BigDecimal getMargemSbCusto() {
		return margemSbCusto;
	}

	public void setMargemSbCusto(BigDecimal margemSbCusto) {
		this.margemSbCusto = margemSbCusto;
	}

	public BigDecimal getMargemSbCustoOferta() {
		return margemSbCustoOferta;
	}

	public void setMargemSbCustoOferta(BigDecimal margemSbCustoOferta) {
		this.margemSbCustoOferta = margemSbCustoOferta;
	}

	public BigDecimal getMargemSbVenda() {
		return margemSbVenda;
	}

	public void setMargemSbVenda(BigDecimal margemSbVenda) {
		this.margemSbVenda = margemSbVenda;
	}

	public BigDecimal getMargemSbVendaOferta() {
		return margemSbVendaOferta;
	}

	public void setMargemSbVendaOferta(BigDecimal margemSbVendaOferta) {
		this.margemSbVendaOferta = margemSbVendaOferta;
	}

	public BigDecimal getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(BigDecimal quantidade) {
		this.quantidade = quantidade;
	}

	public BigDecimal getLucro() {
		return lucro;
	}

	public void setLucro(BigDecimal lucro) {
		this.lucro = lucro;
	}

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	public TipoOferta getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(TipoOferta tipoOferta) {
		this.tipoOferta = tipoOferta;
	}

	public Boolean getEncerraOferta() {
		return encerraOferta;
	}

	public void setEncerraOferta(Boolean encerraOferta) {
		this.encerraOferta = encerraOferta;
	}

	public Integer getEncerraOfertaItens() {
		return encerraOfertaItens;
	}

	public void setEncerraOfertaItens(Integer encerraOfertaItens) {
		this.encerraOfertaItens = encerraOfertaItens;
	}

	public Boolean getBloquearOferta() {
		return bloquearOferta;
	}

	public void setBloquearOferta(Boolean bloquearOferta) {
		this.bloquearOferta = bloquearOferta;
	}

	public BigDecimal getBloquearOfertaItens() {
		return bloquearOfertaItens;
	}

	public void setBloquearOfertaItens(BigDecimal bloquearOfertaItens) {
		this.bloquearOfertaItens = bloquearOfertaItens;
	}

	public Boolean getEnviaConnect() {
		return enviaConnect;
	}

	public void setEnviaConnect(Boolean enviaConnect) {
		this.enviaConnect = enviaConnect;
	}

	public BigDecimal getFatorExclusaoIcms() {
		return fatorExclusaoIcms;
	}

	public void setFatorExclusaoIcms(BigDecimal fatorExclusaoIcms) {
		this.fatorExclusaoIcms = fatorExclusaoIcms;
	}

	public BigDecimal getCustoSemImposto() {
		return custoSemImposto;
	}

	public void setCustoSemImposto(BigDecimal custoSemImposto) {
		this.custoSemImposto = custoSemImposto;
	}

	public BigDecimal getCustoSemImpostoOferta() {
		return custoSemImpostoOferta;
	}

	public void setCustoSemImpostoOferta(BigDecimal custoSemImpostoOferta) {
		this.custoSemImpostoOferta = custoSemImpostoOferta;
	}

	public BigDecimal getCustoComImpostoOferta() {
		return custoComImpostoOferta;
	}

	public void setCustoComImpostoOferta(BigDecimal custoComImpostoOferta) {
		this.custoComImpostoOferta = custoComImpostoOferta;
	}

	public BigDecimal getIcmsDebito() {
		return icmsDebito;
	}

	public void setIcmsDebito(BigDecimal icmsDebito) {
		this.icmsDebito = icmsDebito;
	}

	public BigDecimal getValorAdicional() {
		return valorAdicional;
	}

	public void setValorAdicional(BigDecimal valorAdicional) {
		this.valorAdicional = valorAdicional;
	}

	public BigDecimal getPisCofinsDebito() {
		return pisCofinsDebito;
	}

	public void setPisCofinsDebito(BigDecimal pisCofinsDebito) {
		this.pisCofinsDebito = pisCofinsDebito;
	}

	public BigDecimal getOperacional() {
		return operacional;
	}

	public void setOperacional(BigDecimal operacional) {
		this.operacional = operacional;
	}

	@Override
	public String toString() {
		return "OfertaItem [id=" + id + ", idProduto=" + idProduto + ", custoComImposto=" + custoComImposto
				+ ", precoNormal=" + precoNormal + ", precoOferta=" + precoOferta + ", margemLiquida=" + margemLiquida
				+ ", margemLiquidaOferta=" + margemLiquidaOferta + ", margemBruta=" + margemBruta
				+ ", margemBrutaOferta=" + margemBrutaOferta + ", margemSbCusto=" + margemSbCusto
				+ ", margemSbCustoOferta=" + margemSbCustoOferta + ", margemSbVenda=" + margemSbVenda
				+ ", margemSbVendaOferta=" + margemSbVendaOferta + ", quantidade=" + quantidade + ", lucro=" + lucro
				+ ", oferta=" + oferta + ", tipoOferta=" + tipoOferta + ", encerraOferta=" + encerraOferta
				+ ", encerraOfertaItens=" + encerraOfertaItens + ", bloquearOferta=" + bloquearOferta
				+ ", bloquearOfertaItens=" + bloquearOfertaItens + ", enviaConnect=" + enviaConnect
				+ ", fatorExclusaoIcms=" + fatorExclusaoIcms + ", custoSemImposto=" + custoSemImposto
				+ ", custoSemImpostoOferta=" + custoSemImpostoOferta + ", custoComImpostoOferta="
				+ custoComImpostoOferta + ", icmsDebito=" + icmsDebito + ", valorAdicional=" + valorAdicional
				+ ", pisCofinsDebito=" + pisCofinsDebito + ", operacional=" + operacional + "]";
	}

    

    
}