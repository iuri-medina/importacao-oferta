package com.iurimedina.importacao_oferta.gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.iurimedina.importacao_oferta.model.Loja;
import com.iurimedina.importacao_oferta.model.TipoOferta;
import com.iurimedina.importacao_oferta.service.*;

@Component
public class ImportacaoOfertaGUI extends JFrame implements ActionListener {
	
	
	private LojaService lojaService;

	private TipoOfertaService tipoOfertaService;

	private ImportacaoOfertaService importacaoService;
	
	private Image iconImage;
	

    private final JButton botaoSelecionaArquivo;
    private final JButton botaoImportaOferta;
    private final JTextField caminhoArquivoSelecionado;
    private final JTextField campoDescricao;
    private final JComboBox<Loja> comboBoxLoja;
    private final JComboBox<TipoOferta> comboBoxTipoOferta;
   

    @Autowired
    public ImportacaoOfertaGUI(LojaService lojaService, TipoOfertaService tipoOfertaService, ImportacaoOfertaService importacaoService) {
        super("Importador de Ofertas");
        this.lojaService = lojaService;
        this.tipoOfertaService = tipoOfertaService;
        this.importacaoService = importacaoService;
      
        initUI();
        
        URL iconURL = getClass().getResource("/images/Importador_oferta_64px.png");
        if (iconURL != null) {
            setIconImage(new ImageIcon(iconURL).getImage());
        }

        botaoSelecionaArquivo = new JButton("Selecionar arquivo .CSV");
        botaoSelecionaArquivo.addActionListener(this);

        caminhoArquivoSelecionado = new JTextField(30);
        caminhoArquivoSelecionado.setEditable(false);

        JPanel panelArquivo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelArquivo.add(botaoSelecionaArquivo);
        panelArquivo.add(caminhoArquivoSelecionado);

        comboBoxLoja = new JComboBox<>();
        preencherComboBoxLoja();

        comboBoxTipoOferta = new JComboBox<>();
        preencherComboBoxTipoOferta();

        campoDescricao = new JTextField(30);

        JPanel panelInformacoes = new JPanel(new FlowLayout());
        panelInformacoes.add(new JLabel("Descrição:"));
        panelInformacoes.add(campoDescricao);
        panelInformacoes.add(new JLabel("Loja:"));
        panelInformacoes.add(comboBoxLoja);
        panelInformacoes.add(new JLabel("Tipo Oferta:"));
        panelInformacoes.add(comboBoxTipoOferta);

        botaoImportaOferta = new JButton("Importar Ofertas");
        botaoImportaOferta.setPreferredSize(new Dimension(150, 30));
        botaoImportaOferta.addActionListener(this);
        botaoImportaOferta.setEnabled(false);

        JPanel panelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelBotoes.add(botaoImportaOferta);

        add(panelArquivo, BorderLayout.NORTH);
        add(panelInformacoes, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);
    }
    
    public void initUI() {
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(new Dimension(800, 200));
        
    }  
     

    private void preencherComboBoxLoja() {
        List<Loja> lojas = lojaService.listarLojas();
        for (Loja loja : lojas) {
            comboBoxLoja.addItem(loja);
        }
    }

    private void preencherComboBoxTipoOferta() {
        List<TipoOferta> tipoOfertas = tipoOfertaService.listarTipoOfertas();
        for (TipoOferta tipoOferta : tipoOfertas) {
            comboBoxTipoOferta.addItem(tipoOferta);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botaoSelecionaArquivo) {
            JFileChooser fileChooser = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Arquivos CSV", "csv");
            fileChooser.setFileFilter(filter);

            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                caminhoArquivoSelecionado.setText(selectedFile.getAbsolutePath());
                botaoImportaOferta.setEnabled(true);
            }
        } else if (e.getSource() == botaoImportaOferta) {
            String caminhoArquivo = caminhoArquivoSelecionado.getText();
            String descricao = campoDescricao.getText().toUpperCase();
            Loja lojaSelecionada = (Loja) comboBoxLoja.getSelectedItem();
            TipoOferta tipoOfertaSelecionada = (TipoOferta) comboBoxTipoOferta.getSelectedItem();

            if (caminhoArquivo.isEmpty() || descricao.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Preencha todos os campos corretamente.");
                return;
            }

            importacaoService.importarOfertas(caminhoArquivo, descricao, lojaSelecionada, tipoOfertaSelecionada);
        }
    }
}
