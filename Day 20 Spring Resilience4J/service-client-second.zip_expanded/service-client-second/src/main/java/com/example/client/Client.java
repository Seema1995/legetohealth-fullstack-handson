package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("FIRST-CLIENT/firstclient")
public interface Client {
	
	@GetMapping
	public String callFirstApp();

}
