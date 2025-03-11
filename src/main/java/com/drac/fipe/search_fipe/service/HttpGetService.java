package com.drac.fipe.search_fipe.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpGetService {

    /**
     * Faz uma requisição HTTP GET para a URL especificada e retorna o corpo da resposta como uma string.
     *
     * @param url a URL para enviar a requisição GET
     * @return o corpo da resposta como uma string
     * @throws RuntimeException se ocorrer um erro de I/O ao enviar ou receber
     *                          ou se a operação for interrompida
     * @author Rafael Carvalho
     */
    public String getCallApi(String url) {

        HttpClient http = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> resp = null;

        try {
            resp = http.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        return resp.body();
    }

}
