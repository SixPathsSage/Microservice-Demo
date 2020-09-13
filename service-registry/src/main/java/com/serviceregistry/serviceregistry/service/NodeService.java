package com.serviceregistry.serviceregistry.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serviceregistry.serviceregistry.model.Node;
import com.serviceregistry.serviceregistry.model.ServiceMethods;
import com.serviceregistry.serviceregistry.repository.NodeRepository;

@Service
public class NodeService {

	@Autowired
	private NodeRepository repo;
	
	public List<Node> getAllNodes() {
		return repo.findAll();
	}
	
	public Node getNode(String serviceName) {
		return repo.findByServiceName(serviceName).orElseThrow();
	}
	
	public Node registerNode(Node node) {
		return repo.save(node);
	}
	
	public Node registerMethod(ServiceMethods serviceMethods) {
		Node node = getNode(serviceMethods.getServiceName());
		node.getMethods().addAll(serviceMethods.getMethods());
		return repo.save(node);
	}
	
	public void removeNode(Node node) {
		repo.delete(node);
	}
}
