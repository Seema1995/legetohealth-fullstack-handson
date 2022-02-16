package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("APP1/ms1")
public interface Client {
	
	@GetMapping
	public String invokeFirstApp();

}
