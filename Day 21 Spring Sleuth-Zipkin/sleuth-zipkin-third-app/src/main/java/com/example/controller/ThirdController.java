package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.Client;

@RestController
@RequestMapping("ms3")
public class ThirdController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private Client client;
	
	@GetMapping
	public String m3() {
		LOG.info("-----Inside m3()---------");
		String data = client.invokeSecondApp();
		return "Hello from third ms. Calling second Ms. Data : "+data;
	}
}
