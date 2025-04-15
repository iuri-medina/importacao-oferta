package com.iurimedina.importacao_oferta.service;

import java.awt.Dimension;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.*;

import org.apache.commons.csv.*;

import com.iurimedina.importacao_oferta.dto.OfertaCSVDTO;
import com.iurimedina.importacao_oferta.dto.ProdutoInfoDTO;
import com.iurimedina.importacao_oferta.exception.ImportacaoException;
import com.iurimedina.importacao_oferta.model.*;
import com.iurimedina.importacao_oferta.repository.*;
import com.iurimedina.importacao_oferta.util.LogDiario;
import com.iurimedina.importacao_oferta.util.LogOfertasNaoImportadas;



@Service
public class ImportacaoOfertaService {

    private final OfertaRepository ofertaRepository;
    private final OfertaItemRepository ofertaItemRepository;
    private final OfertaItemConnectRepository ofertaItemConnectRepository;
    private final ProdutoAutomacaoRepository produtoAutomacaoRepository;

    private List<String> produtosNaoEncontrados = new ArrayList<>();

    @Autowired
    public ImportacaoOfertaService(
                                 OfertaRepository ofertaRepository,
                                 OfertaItemRepository ofertaItemRepository,
                                 OfertaItemConnectRepository ofertaItemConnectRepository,
                                 ProdutoAutomacaoRepository produtoAutomacaoRepository) {
        this.ofertaRepository = ofertaRepository;
        this.ofertaItemRepository = ofertaItemRepository;
        this.ofertaItemConnectRepository = ofertaItemConnectRepository;
        this.produtoAutomacaoRepository = produtoAutomacaoRepository;
    }


    @Transactional
    public void importarOfertas(String caminhoArquivo, String descricao, Loja loja, TipoOferta tipoOferta) {
        try {
        	int idOferta = 0;
        	idOferta = ofertaRepository.findMaxIdOferta();
        	
            List<OfertaCSVDTO> ofertasCSV = lerArquivoCSV(caminhoArquivo);
            validarDadosImportacao(descricao);
            
            Oferta oferta = criarESalvarOferta(idOferta, descricao);
            processarItensOferta(ofertasCSV, loja, tipoOferta, oferta);
            exibirResultadoImportacao();
            
        } catch (ImportacaoException e) {
            LogDiario.info("Erro na importacao: " + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        } catch (Exception e) {
            LogDiario.info("Erro inesperado: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Ocorreu um erro inesperado durante a importação.");
        }
    }

    private List<OfertaCSVDTO> lerArquivoCSV(String caminhoArquivo) throws ImportacaoException {
        List<OfertaCSVDTO> ofertas = new ArrayList<>();
        
        try (FileReader fileReader = new FileReader(caminhoArquivo);
             CSVParser csvParser = new CSVParser(fileReader, 
                     CSVFormat.DEFAULT.withDelimiter(';').withFirstRecordAsHeader())) {
            
            for (CSVRecord csvRecord : csvParser) {
                OfertaCSVDTO oferta = new OfertaCSVDTO(
                    (int) csvRecord.getRecordNumber(),
                    csvRecord.get(0),  // codigoBarras
                    csvRecord.get(1),  // preco
                    csvRecord.get(2),  // connect
                    csvRecord.get(3),  // precoConnect
                    csvRecord.get(4)   // ativePague 
                );
                ofertas.add(oferta);
            }
            return ofertas;
            
        } catch (IOException e) {
        	LogDiario.info("Erro: " + e.getMessage());
            throw new ImportacaoException("Erro ao ler arquivo CSV: " + e.getMessage());
        }
    }

    private void validarDadosImportacao(String descricao) throws ImportacaoException {
        if (descricao == null || descricao.trim().isEmpty()) {
        	LogDiario.info("Erro: O campo descricao é obrigatório");
            throw new ImportacaoException("O campo descriçao é obrigatório.");
        }
    }

    private Oferta criarESalvarOferta(int id, String descricao) {
        Oferta oferta = new Oferta();
        oferta.setId(id+1);
        oferta.setDescricao(descricao.toUpperCase());
        oferta.setData(LocalDate.now());
        return ofertaRepository.save(oferta);
    }

    private void processarItensOferta(List<OfertaCSVDTO> dadosCSV, Loja loja, TipoOferta tipoOferta, Oferta oferta) {
        for (OfertaCSVDTO ofertaCSV : dadosCSV) {
            try {
                Optional<ProdutoInfoDTO> produtoInfo = buscarProdutoPorCodigoBarras(ofertaCSV.getCodigoBarras(), loja.getId());
                
                if (!produtoInfo.isPresent()) {
                    registrarProdutoNaoEncontrado(ofertaCSV.getNumeroLinhaCSV());
                    continue;
                }
                
                criarItemOferta(ofertaCSV, loja, tipoOferta, oferta, produtoInfo.get());
                
            } catch (Exception e) {
                LogDiario.info("Erro ao processar linha " + ofertaCSV.getNumeroLinhaCSV() + ": " + e.getMessage());
                registrarProdutoNaoEncontrado(ofertaCSV.getNumeroLinhaCSV());
            }
        }
    }

    private Optional<ProdutoInfoDTO> buscarProdutoPorCodigoBarras(String codigoBarras, Integer idLoja) {
        try {
            Long codigo = Long.parseLong(codigoBarras);
            return produtoAutomacaoRepository.findProdutoByCodigoBarras(codigo, idLoja);
        } catch (NumberFormatException e) {
            LogDiario.info("Codigo de barras invalido: " + codigoBarras);
            return Optional.empty();
        }
    }

    private void registrarProdutoNaoEncontrado(int numeroLinha) {
        produtosNaoEncontrados.add(String.valueOf(numeroLinha));
        LogDiario.info("Produto não encontrado na linha: " + numeroLinha);
    }

    private void criarItemOferta(OfertaCSVDTO ofertaCSV, Loja loja, TipoOferta tipoOferta, 
                               Oferta oferta, ProdutoInfoDTO produtoInfo) {
        
        OfertaItem ofertaItem = new OfertaItem();
        //Produto produto = new Produto(produtoInfo.getIdProduto());
        ofertaItem.setIdProduto(produtoInfo.getIdProduto());
        ofertaItem.setPrecoOferta(converterParaBigDecimal(ofertaCSV.getPreco()));
        ofertaItem.setOferta(oferta);
        ofertaItem.setTipoOferta(tipoOferta);
        ofertaItem.setPrecoNormal(produtoInfo.getPrecoVenda());
        ofertaItem.setCustoComImposto(produtoInfo.getCustoComImposto());
        ofertaItem.setMargemLiquida(produtoInfo.getMargemLiquida());
        ofertaItem.setMargemBruta(produtoInfo.getMargemBruta());
        ofertaItem.setMargemSbCusto(produtoInfo.getMargemSbCusto());
        ofertaItem.setMargemSbVenda(produtoInfo.getMargemSbVenda());
        ofertaItem.setCustoSemImposto(produtoInfo.getCustoSemImposto());
        ofertaItem.setIcmsDebito(produtoInfo.getIcmsDebito());
        ofertaItem.setPisCofinsDebito(produtoInfo.getPisCofinsDebito());
        
        
        
        OfertaItem itemSalvo = ofertaItemRepository.save(ofertaItem);
        
        if ("sim".equalsIgnoreCase(ofertaCSV.getConnect())) {
        	if("sim".equalsIgnoreCase(ofertaCSV.getAtivePague())) {
        		criarItemOfertaConnect(itemSalvo, produtoInfo, ofertaCSV.getPrecoConnect(), true);
        	}
        	else {
                criarItemOfertaConnect(itemSalvo, produtoInfo, ofertaCSV.getPrecoConnect(), false);
        	}
        }
    }

    private BigDecimal converterParaBigDecimal(String valor) {
        try {
            return new BigDecimal(valor.replace(",", "."));
        } catch (NumberFormatException e) {
            LogDiario.info("Valor inválido para conversão: " + valor);
            return BigDecimal.ZERO;
        }
    }

    private void criarItemOfertaConnect(OfertaItem ofertaItem, ProdutoInfoDTO produtoInfo, String precoConnect, Boolean ativePague) {
        OfertaItemConnect connect = new OfertaItemConnect();
        connect.setOfertaItem(ofertaItem);
        connect.setDescricao(produtoInfo.getDescricaoCompleta());
        connect.setPrecoConnect(converterParaBigDecimal(precoConnect));
        connect.setTipoOrigemImagem(1);
        connect.setAtivePague(ativePague);
        
        ofertaItemConnectRepository.save(connect);
    }

    private void exibirResultadoImportacao() {
        if (!produtosNaoEncontrados.isEmpty()) {
            String linhasNaoImportadas = String.join(", ", produtosNaoEncontrados);
            
            JTextArea textArea = new JTextArea(
                "Ofertas não importadas - linhas: " + linhasNaoImportadas + "\n\n" +
                "As demais ofertas foram importadas com sucesso."
            );
            textArea.setEditable(false);
            textArea.setLineWrap(true);
            textArea.setWrapStyleWord(true);
            
            JScrollPane scrollPane = new JScrollPane(textArea);
            scrollPane.setPreferredSize(new Dimension(500, 150));
            
            JOptionPane.showMessageDialog(null, scrollPane, "Resultado da Importacao", JOptionPane.INFORMATION_MESSAGE);
            
            LogOfertasNaoImportadas.adicionarOfertaNaoImportada(linhasNaoImportadas);
            produtosNaoEncontrados.clear();
        } else {
            JOptionPane.showMessageDialog(null, 
                "Todas as ofertas foram importadas com sucesso.", 
                "Importaçao Concluida", 
                JOptionPane.INFORMATION_MESSAGE);
            LogDiario.info("Todas as ofertas foram importadas com sucesso.");
            LogDiario.info("Importaçao Concluida");
        }
    }
}