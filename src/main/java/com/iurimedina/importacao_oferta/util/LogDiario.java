package com.iurimedina.importacao_oferta.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.logging.*;

public class LogDiario {
    private static final Logger LOGGER = Logger.getLogger(LogDiario.class.getName());
    private static final int MAX_LOG_FILES = 20;
    private static final String LOG_DIRECTORY = "importador-oferta-log";
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat DATE_FORMAT_LOG_LINE = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void init() {
        // Configurar o formatter
        SimpleFormatter formatter = new SimpleFormatter() {
            @Override
            public String format(LogRecord record) {
                return DATE_FORMAT_LOG_LINE.format(new Date()) + " " + record.getLevel() + " " + record.getMessage() + "\n";
            }
        };
        
      // Configurar o file handler
        File logDir = new File(LOG_DIRECTORY);
        logDir.mkdirs(); // Cria o diretório se não existir
        FileHandler fh = null;
        try {
            String fileName = "importador-oferta-" + DATE_FORMAT.format(new Date()) + ".log";
            fh = new FileHandler(LOG_DIRECTORY + "/" + fileName, true);
        } catch (IOException e) {
            LOGGER.severe("Erro ao criar FileHandler: " + e.getMessage());
        }
        fh.setFormatter(formatter);
        LOGGER.addHandler(fh);

        // Iniciar a thread de rotação de arquivos
        startRotationThread();
    }

    public static void info(String message) {
        LOGGER.info(message);
    }


    private static void startRotationThread() {
        new Thread(() -> {
            while (true) {
                try {
                    // Obtém todos os arquivos de log no diretório
                    File[] logFiles = new File(LOG_DIRECTORY).listFiles((dir, name) -> name.startsWith("log-"));
                    if (logFiles == null) {
                        continue; // Nenhum arquivo encontrado
                    }
                    Arrays.sort(logFiles);

                    // Remove arquivos excedentes
                    int filesToRemove = Math.max(0, logFiles.length - MAX_LOG_FILES);
                    for (int i = 0; i < filesToRemove; i++) {
                        logFiles[i].delete();
                    }

                    // Aguarda 1 hora antes de verificar novamente
                    Thread.sleep(3600000);
                } catch (InterruptedException e) {
                    LOGGER.log(Level.SEVERE, "Erro na rotacao de arquivos de log", e);
                }
            }
        }).start();
    }
}