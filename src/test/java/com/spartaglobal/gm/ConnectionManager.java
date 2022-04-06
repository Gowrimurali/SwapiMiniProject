package com.spartaglobal.gm;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConnectionManager {
    private static final String BASEURL = "https://swapi.dev/api/people/";
    private static String endPoint;
    private static HttpResponse httpResponse;
    

    public static String getConnection() {
        getResponse(1);
        return BASEURL;
    }

    public static String getConnection(int number) {
        return BASEURL + number + "/";
    }

    public static int getStatusCode() {
        return getResponse(1).statusCode();
    }
    private static HttpResponse<String> getResponse(int number) {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(getConnection(number))).build();
        HttpResponse<String> httpResponse = null;
        try {
            httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return httpResponse;
    }

    public static HttpResponse<String> getConnectionResponse(int number) {
        return getResponse(number);
    }

    public String getURL() {
        return BASEURL + endPoint;
    }
}
