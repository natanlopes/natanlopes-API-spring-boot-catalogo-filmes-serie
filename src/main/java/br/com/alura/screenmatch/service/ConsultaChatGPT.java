package br.com.alura.screenmatch.service;

import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaChatGPT {

	public static String obterTraducao(String texto) throws Exception {
	    String url = "https://api-inference.huggingface.co/models/Helsinki-NLP/opus-mt-en-ROMANCE";
	    String token = "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"; // Token correto

	    String body = "{ \"inputs\": \"" + texto + "\" }";

	    HttpClient client = HttpClient.newHttpClient();
	    HttpRequest request = HttpRequest.newBuilder()
	            .uri(new URI(url))
	            .header("Authorization", "Bearer " + token)
	            .header("Content-Type", "application/json")
	            .POST(HttpRequest.BodyPublishers.ofString(body))
	            .build();

	    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
	    String resposta = response.body();

	    // Validar a resposta
	    if (resposta.contains("error")) {
	        return "Tradução não disponível no momento.";
	    } else {
	        return resposta; // Ajuste para extrair o texto correto da resposta JSON
	        
	        
	        
	    }
	}

	
	
}