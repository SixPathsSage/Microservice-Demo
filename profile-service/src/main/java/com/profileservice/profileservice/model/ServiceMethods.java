package com.profileservice.profileservice.model;

import java.util.List;

public class ServiceMethods {

	private String serviceName;
	private List<String> methods;

	public ServiceMethods() {
		super();
	}

	public ServiceMethods(String serviceName, List<String> methods) {
		super();
		this.serviceName = serviceName;
		this.methods = methods;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public List<String> getMethods() {
		return methods;
	}

	public void setMethods(List<String> methods) {
		this.methods = methods;
	}

	@Override
	public String toString() {
		return "ServiceMethods [serviceName=" + serviceName + ", methods=" + methods + "]";
	}

}
