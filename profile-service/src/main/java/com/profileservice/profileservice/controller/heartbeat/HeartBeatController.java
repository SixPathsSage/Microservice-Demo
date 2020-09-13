package com.profileservice.profileservice.controller.heartbeat;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HeartBeatController {

	@GetMapping("/health")
	public ResponseEntity<String> getHealth() {
		return new ResponseEntity<String>(HttpStatus.OK);
	}
}
