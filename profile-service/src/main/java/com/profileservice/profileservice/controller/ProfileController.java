package com.profileservice.profileservice.controller;

import javax.websocket.server.PathParam;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.profileservice.profileservice.model.Profile;

@RestController
public class ProfileController {

	@GetMapping("/profile/{id}")
	public ResponseEntity<Profile> getProfile(@PathParam("id") int id) {
		return new ResponseEntity<Profile>(new Profile(id, "Siddharth"),HttpStatus.OK);
	}
}
