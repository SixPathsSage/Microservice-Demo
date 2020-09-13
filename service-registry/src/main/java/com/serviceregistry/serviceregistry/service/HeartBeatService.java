package com.serviceregistry.serviceregistry.service;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.serviceregistry.serviceregistry.model.Node;

@Configuration
@Component
@EnableScheduling
public class HeartBeatService {
	
	@Autowired
	private NodeService service;
	
	private Logger logger = LoggerFactory.getLogger(HeartBeatService.class);;
	
	@Autowired
	private RestTemplate template;
	

	@Scheduled(fixedRate = 1000)
	public void heartbeat() throws RestClientException, URISyntaxException {
		List<Node> nodes = service.getAllNodes();
		System.out.println(nodes.size());
		for(Node node: nodes) {
			final String url = "http://" + node.getIp() + ":" + node.getPort() + "/health";
			ResponseEntity<String> response = template.getForEntity(new URI(url), String.class);
			handleResponse(node, response);
		}
	}

	private void handleResponse(Node node, ResponseEntity<String> response) {
		if(response.getStatusCode() != HttpStatus.OK) {
			service.removeNode(node);
			logger.error("Status Code " + response.getStatusCodeValue());
		}
		else {
			logger.info(node.getServiceName() + " is alive");
		}
	}
}
