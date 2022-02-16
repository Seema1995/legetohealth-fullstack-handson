package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("firstclient")
public class FirstController {
	
	@GetMapping
	public ResponseEntity<Object> callFirstApp(){
		return ResponseEntity.status(200).body("First Client");
	}

}
