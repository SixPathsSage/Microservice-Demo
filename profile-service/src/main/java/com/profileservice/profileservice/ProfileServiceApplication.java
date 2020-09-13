package com.profileservice.profileservice;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.profileservice.profileservice.model.Node;

@SpringBootApplication
public class ProfileServiceApplication {

	public static void main(String[] args) throws URISyntaxException {
		RestTemplate template = new RestTemplate();
		Node node = new Node("profile", "localhost", 9093, Arrays.asList("profile"));
		RequestEntity<Node> request = RequestEntity
				.post(new URI("http://localhost:9092/registry/node/register"))
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.body(node);
		ResponseEntity<Node> response = template.exchange("http://localhost:9092/registry/node/register", HttpMethod.POST, request, new ParameterizedTypeReference<Node>() {
		});
		response.getBody();
		SpringApplication.run(ProfileServiceApplication.class, args);
	}

}
