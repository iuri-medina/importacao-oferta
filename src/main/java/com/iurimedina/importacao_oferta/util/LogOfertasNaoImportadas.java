package com.iurimedina.importacao_oferta.util;

import java.io.FileWriter;
import java.io.IOException;

public class LogOfertasNaoImportadas {
    private static final String NOME_ARQUIVO = "ofertas_nao_importadas.log";

    public static void adicionarOfertaNaoImportada(String oferta) {
        try (FileWriter writer = new FileWriter(NOME_ARQUIVO, false)) {
        	writer.write("As ofertas que se encontram nas linhas do arquivo .CSV listadas abaixo nao foram importadas: \n");
            writer.write(oferta + "\n");
            writer.flush();
        } catch (IOException e) {
            System.err.println("Erro ao escrever no arquivo de log: " + e.getMessage());
        }
    }
}
