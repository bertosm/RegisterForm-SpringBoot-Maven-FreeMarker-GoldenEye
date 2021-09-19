package com.codebay.goldeneye.services;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.codebay.goldeneye.models.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserService {

    private final String URLAPI = "http://localhost:8080/unnapropiatedwords";

    public Boolean checkEmail(String Email){
        //Not Implemented.
        return false;
    }

    public String unappropiatedWords(User user) {

        // connection to API.
        ObjectMapper objectMapper = new ObjectMapper();
        String body;

        try {
            body = objectMapper.writeValueAsString(user);

        } catch (JsonProcessingException e1) {
            System.out.println("Error User cant be cast to JSON");
            System.out.println(e1.getMessage());
            return "ERROR";
        }

        System.out.println(body);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(this.URLAPI))
            .POST(HttpRequest.BodyPublishers.ofString(body))
            .build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            String responseBody = response.body();
            int responseCode = response.statusCode();

            if(responseCode/100 == 2){
                System.out.println("API OK" + responseCode);
                return responseBody;


            }else if (responseCode/100 == 5){
                System.out.println("Error API is down: " + responseCode);
                return "ERRROR";
            }else {
                System.out.println("Error " + responseCode);
                return "ERROR";
            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            return "ERROR";

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return "ERROR";
        }
    }
}
