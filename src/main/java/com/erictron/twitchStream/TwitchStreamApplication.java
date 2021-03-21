package com.erictron.twitchStream;

import com.erictron.JPA.User;
import com.erictron.TWITCHOATH.TWITCHOATH;
import com.erictron.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@SpringBootApplication
public class TwitchStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(TwitchStreamApplication.class, args);
		HttpClient httpClient = HttpClient.newHttpClient();
		try {
			URI uriErryonTV = new URI("https://api.twitch.tv/helix/users?login=ErryonTV");//your url i.e fetch data from .
			HttpRequest request2 = HttpRequest.newBuilder()
					.uri(uriErryonTV)
					.setHeader("Authorization", TWITCHOATH.TWITCHOATHFUNCTION())
					.setHeader("Client-Id", TWITCHOATH.TWITCHCLIENTID())
					.build();

			HttpResponse<String> response2 = httpClient.send(request2,
					HttpResponse.BodyHandlers.ofString());

			System.out.println(response2.body());


		} catch (Exception e) {
			System.out.println("Exception in NetClientGet:- " + e);
		}
	}



}
