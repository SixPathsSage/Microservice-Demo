package com.serviceregistry.serviceregistry.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serviceregistry.serviceregistry.model.Node;

public interface NodeRepository extends JpaRepository<Node, Integer> {
	public Optional<Node> findByServiceName(String serviceName);
}
