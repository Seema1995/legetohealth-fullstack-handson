package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ms1")
public class FirstController {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	@GetMapping
	public String m1() {
		LOG.info("-----Inside m1()---------");
		return "Hello from first ms";
	}
}
