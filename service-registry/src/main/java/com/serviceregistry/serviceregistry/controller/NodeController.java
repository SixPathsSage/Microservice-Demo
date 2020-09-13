package com.serviceregistry.serviceregistry.controller;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serviceregistry.serviceregistry.model.Node;
import com.serviceregistry.serviceregistry.model.ServiceMethods;
import com.serviceregistry.serviceregistry.service.NodeService;

@RestController
@RequestMapping("/registry")
public class NodeController {
	
	@Autowired
	private NodeService service;

	@GetMapping("/node/{serviceName}")
	public Node getNode(@PathParam("serviceName") String serviceName) {
		return service.getNode(serviceName);
	}
	
	@PostMapping("/node/register")
	public Node registerNode(@RequestBody Node node) {
		return service.registerNode(node);
	}
	
	@PutMapping("/node/methods")
	public Node regsiterMethods(@RequestBody ServiceMethods serviceMethods) {
		return service.registerMethod(serviceMethods);
	}
}
