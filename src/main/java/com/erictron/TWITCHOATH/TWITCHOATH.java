package com.erictron.TWITCHOATH;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

/**
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAMNE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 * NE PAS MONTER EN STREAM
 */
public class TWITCHOATH {

    public static String TWITCHOATHFUNCTION() {
            try {
                URI uriOath = new URI("https://id.twitch.tv/oauth2/token?");//your url i.e fetch data from .
                HttpClient httpClient = HttpClient.newHttpClient();

                Map<Object, Object> data = new HashMap<>();
                data.put("client_id", "xxxx"); // TODO ICI REMPLACER PAR CLIENT ID
                data.put("client_secret", "xxxx"); // TODO ICI REMPLACER PAR CLIENT SECRET
                data.put("grant_type", "client_credentials");

                HttpRequest request = HttpRequest.newBuilder()
                        .POST(ofFormData(data))
                        .uri(uriOath)
                        .build();

                HttpResponse<String> response =
                        httpClient.send(request, HttpResponse.BodyHandlers.ofString());

                ObjectMapper mapper = new ObjectMapper();
                OATH oath = mapper.readValue(response.body(), OATH.class);

                return "Bearer " + oath.access_token;

            } catch (Exception e) {
                return "ERREUR";
            }

    }

    public static String TWITCHCLIENTID() {
        return "a6ez3w8l67mc5ily4u8kc4sn7nmbqe";
    }

    public static HttpRequest.BodyPublisher ofFormData(Map<Object, Object> data) {
        var builder = new StringBuilder();
        for (Map.Entry<Object, Object> entry : data.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey().toString(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue().toString(), StandardCharsets.UTF_8));
        }
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
}


