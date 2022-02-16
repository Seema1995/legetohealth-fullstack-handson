package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.client.Client;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceForSecondApp {
	
	@Autowired
	private Client client;
	
	@CircuitBreaker(name = "fetchFirstApp", fallbackMethod = "getFirstAppDataAlternately")
	public String getFirstAppDataFromSecondApp() {
		String data = client.callFirstApp();
		return data;
	}
	
	public String getFirstAppDataAlternately(Throwable t) {
		System.out.println("-------Fallback called in second app------");
		return "Alternate response from fallback method";
	}
	

}
