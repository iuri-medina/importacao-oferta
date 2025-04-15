package com.iurimedina.importacao_oferta;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import com.iurimedina.importacao_oferta.gui.ImportacaoOfertaGUI;
import com.iurimedina.importacao_oferta.util.LogDiario;

@SpringBootApplication
public class ImportacaoOfertaApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = new SpringApplicationBuilder(ImportacaoOfertaApplication.class)
	            .headless(false)
	            .run(args);
				
				LogDiario.init();

				// Inicia a interface Swing no thread de eventos
	        	javax.swing.SwingUtilities.invokeLater(() -> {
	            ImportacaoOfertaGUI gui = ctx.getBean(ImportacaoOfertaGUI.class);
	            gui.setVisible(true);
	        });
	}

}
