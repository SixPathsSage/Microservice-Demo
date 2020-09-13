package com.serviceregistry.serviceregistry.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Node {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String serviceName;
	private String ip;
	private int port;
	
	@ElementCollection(targetClass = String.class)
	private List<String> methods;

	public Node() {
		super();
		methods = new ArrayList<>();
	}

	public Node(String serviceName, String ip, int port) {
		super();
		this.serviceName = serviceName;
		this.ip = ip;
		this.port = port;
		this.methods = new ArrayList<>();
	}

	public Node(String serviceName, String ip, int port, ArrayList<String> methods) {
		super();
		this.serviceName = serviceName;
		this.ip = ip;
		this.port = port;
		this.methods = methods;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return "Node [id=" + id + ", serviceName=" + serviceName + ", ip=" + ip + ", port=" + port + ", methods="
				+ methods + "]";
	}

}
