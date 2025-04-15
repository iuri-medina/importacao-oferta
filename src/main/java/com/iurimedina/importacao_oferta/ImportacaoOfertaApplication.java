package com.iurimedina.importacao_oferta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.JOptionPane;

import com.iurimedina.importacao_oferta.gui.ImportacaoOfertaGUI;
import com.iurimedina.importacao_oferta.service.ValidadorChaveService;
import com.iurimedina.importacao_oferta.util.ApiProperties;
import com.iurimedina.importacao_oferta.util.LogDiario;

@SpringBootApplication
public class ImportacaoOfertaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(ImportacaoOfertaApplication.class)
	            .headless(false)
	            .run(args);
				
				LogDiario.init();
				
				ApiProperties apiProperties = ctx.getBean(ApiProperties.class);
				ValidadorChaveService validadorChaveService = ctx.getBean(ValidadorChaveService.class);			
				
				LogDiario.info("Validando chave: " + apiProperties.getChave() + " API: http://" + apiProperties.getIp() + ":" +apiProperties.getPorta()+"/validacao-chave-cliente");
				boolean isChaveValida = validadorChaveService.validarChave(apiProperties.getChave(), apiProperties.getIp(), apiProperties.getPorta());
				
				if(!isChaveValida) {
					JOptionPane.showMessageDialog(null, "Chave invalida, contate o suporte.");
					LogDiario.info("Chave invalida, contate o suporte.");
					SpringApplication.exit(ctx, () -> 1);
					System.exit(1);
				}
				
				LogDiario.info("Chave valida! inicializando programa.");

				// Inicia a interface Swing no thread de eventos
	        	javax.swing.SwingUtilities.invokeLater(() -> {
	            ImportacaoOfertaGUI gui = ctx.getBean(ImportacaoOfertaGUI.class);
	            gui.setVisible(true);
	            
	            
	        });
	}

}
