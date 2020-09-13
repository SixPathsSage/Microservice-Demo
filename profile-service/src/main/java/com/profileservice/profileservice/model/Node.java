package com.profileservice.profileservice.model;

import java.util.List;


public class Node {
	private String serviceName;
	private String ip;
	private int port;
	private List<String> methods;

	public Node() {
		super();
	}

	public Node(String serviceName, String ip, int port, List<String> methods) {
		super();
		this.serviceName = serviceName;
		this.ip = ip;
		this.port = port;
		this.methods = methods;
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
		return "Node [serviceName=" + serviceName + ", ip=" + ip + ", port=" + port + ", methods="
				+ methods + "]";
	}

}
