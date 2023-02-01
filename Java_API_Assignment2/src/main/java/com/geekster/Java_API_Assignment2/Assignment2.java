package com.geekster.Java_API_Assignment2;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.http.client.utils.URIBuilder;

public class Assignment2 {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		URIBuilder url = new URIBuilder("https://api.weatherbit.io/v2.0/current");
		
		url.setParameter("key", "6d84aa58766f4e11bd9f6cefe427c7ab");
		url.setParameter("city", "Ahmedabad");
		
		String uri = url.build().toString();
		
		HttpRequest httpRequest = HttpRequest.newBuilder().GET().uri(URI.create(uri)).build();
		
		HttpClient httpClient = HttpClient.newBuilder().build();
		
		HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		
		System.out.println(response.body());
	}

}
