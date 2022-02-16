package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.Client;

@RestController
@RequestMapping("ms2")
public class SecondController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Client client;
	
	@GetMapping
	public String m1() {
		LOG.info("-----Inside m2()---------");
		String data = client.invokeFirstApp();
		return "Hello from second ms call to first app. Data : "+data;
	}
}
