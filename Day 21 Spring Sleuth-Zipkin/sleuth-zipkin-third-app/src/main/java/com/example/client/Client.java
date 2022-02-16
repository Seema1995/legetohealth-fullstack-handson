package com.example.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("APP2/ms2")
public interface Client {
	
	@GetMapping
	public String invokeSecondApp();

}
