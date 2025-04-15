package com.iurimedina.importacao_oferta.model;

import java.math.BigDecimal;

import jakarta.persistence.*;

@Entity
@Table(name = "simulacaoofertaitem", schema = "connect")
public class OfertaItemConnect {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne
    @JoinColumn(name = "id_simulacaoofertaitem", referencedColumnName = "id")
    private OfertaItem ofertaItem;

    @Column(name = "id_tipoorigemimagem")
    private Integer tipoOrigemImagem = 3;

    @Column(name = "id_imagemconnect")
    private Integer idImagemConnect;

    @Column(name = "descricao", length = 255)
    private String descricao;

    @Column(name = "precoconnect", precision = 19, scale = 4)
    private BigDecimal precoConnect;

    @Column(name = "prioridade")
    private Boolean prioridade = false;

    @Column(name = "limitaroferta")
    private Boolean limitarOferta = false;

    @Column(name = "observacao", length = 255)
    private String observacao;

    @Column(name = "quantidadelimitaroferta")
    private Integer quantidadeLimitarOferta = 0;

    @Column(name = "imagempersonalizada", length = 255)
    private String imagemPersonalizada;

    @Column(name = "ativepague")
    private Boolean ativePague = false;

    // Construtores
    public OfertaItemConnect() {
    }

    public OfertaItemConnect(OfertaItem ofertaItem, Integer tipoOrigemImagem, String descricao, 
                           BigDecimal precoConnect) {
        this.ofertaItem = ofertaItem;
        this.tipoOrigemImagem = tipoOrigemImagem;
        this.descricao = descricao;
        this.precoConnect = precoConnect;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OfertaItem getOfertaItem() {
        return ofertaItem;
    }

    public void setOfertaItem(OfertaItem ofertaItem) {
        this.ofertaItem = ofertaItem;
    }

    public Integer getTipoOrigemImagem() {
        return tipoOrigemImagem;
    }

    public void setTipoOrigemImagem(Integer tipoOrigemImagem) {
        this.tipoOrigemImagem = tipoOrigemImagem;
    }

    public Integer getIdImagemConnect() {
        return idImagemConnect;
    }

    public void setIdImagemConnect(Integer idImagemConnect) {
        this.idImagemConnect = idImagemConnect;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPrecoConnect() {
        return precoConnect;
    }

    public void setPrecoConnect(BigDecimal precoConnect) {
        this.precoConnect = precoConnect;
    }

    public Boolean getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(Boolean prioridade) {
        this.prioridade = prioridade;
    }

    public Boolean getLimitarOferta() {
        return limitarOferta;
    }

    public void setLimitarOferta(Boolean limitarOferta) {
        this.limitarOferta = limitarOferta;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getQuantidadeLimitarOferta() {
        return quantidadeLimitarOferta;
    }

    public void setQuantidadeLimitarOferta(Integer quantidadeLimitarOferta) {
        this.quantidadeLimitarOferta = quantidadeLimitarOferta;
    }

    public String getImagemPersonalizada() {
        return imagemPersonalizada;
    }

    public void setImagemPersonalizada(String imagemPersonalizada) {
        this.imagemPersonalizada = imagemPersonalizada;
    }

    public Boolean getAtivePague() {
        return ativePague;
    }

    public void setAtivePague(Boolean ativePague) {
        this.ativePague = ativePague;
    }

    @Override
    public String toString() {
        return "OfertaItemConnect{" +
                "id=" + id +
                ", ofertaItem=" + (ofertaItem != null ? ofertaItem.getId() : null) +
                ", descricao='" + descricao + '\'' +
                ", precoConnect=" + precoConnect +
                '}';
    }
}