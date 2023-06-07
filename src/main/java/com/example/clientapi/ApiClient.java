package com.example.clientapi;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/time")).GET().build();
        String path="http://localhost:8080/api/getImage";

        HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
        String apiResponse = response.body();
        System.out.println(apiResponse);

        HttpRequest requestip = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/api/json")).GET().build();
        HttpResponse<String> ip = httpClient.send(requestip, HttpResponse.BodyHandlers.ofString());
        String apiip = ip.body();
        System.out.println(apiip);
        try {

            HttpRequest httpRequest=HttpRequest.newBuilder()
                    .uri(new URI(path))
                    .header("Content-Type","application/json")
                    .GET().build();
            HttpResponse<byte[]> image=httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofByteArray());
            System.out.println(image.body().length);
        }catch (Exception e){
            System.out.println(e);
        }

    }
}