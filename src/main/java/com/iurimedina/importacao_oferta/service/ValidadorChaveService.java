package com.iurimedina.importacao_oferta.service;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.iurimedina.importacao_oferta.dto.FornecedorDto;
import com.iurimedina.importacao_oferta.repository.FornecedorRepository;
import com.iurimedina.importacao_oferta.util.LogDiario;

@Component
public class ValidadorChaveService {
	
	@Autowired
	FornecedorRepository fornecedorRepository;
	
	public boolean validarChave(String chave, String ip, String porta) {
		
		FornecedorDto fornecedorDto = fornecedorRepository.findCnpj();
		String cnpj = fornecedorDto.getCnpj();
		
		LogDiario.info("cnpj - " + cnpj);
		
		try {
			
			URL url = new URL(String.format("http://%s:%s/validacao-chave-cliente", ip, porta));
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json");
			con.setDoOutput(true);
			
	        String jsonInputString = String.format("{\"chave\": \"%s\", \"cnpj\": \"%s\"}", chave, cnpj);
	        
	        try (OutputStream os = con.getOutputStream()) {
	            byte[] input = jsonInputString.getBytes("utf-8");
	            os.write(input, 0, input.length);
	        }

	        int code = con.getResponseCode();
	        LogDiario.info("Codigo retornado da API: " + code);
	        return code == 200;

		} catch (Exception e) {
        e.printStackTrace();
        LogDiario.info(e.getMessage());
        return false;
		}

	}
}
