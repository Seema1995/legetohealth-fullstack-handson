package com.legatohealth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.legatohealth.client.Client;

@RestController
@RequestMapping("secondapp")
public class SecondAppController {
	@Autowired
	private RestTemplate template;    //this has methods like get(),put(),post(),delete()
	
	@Autowired
	private Client client;
	
	@GetMapping("one")
	public ResponseEntity<Object> callFirstAppUsingRestTemplate(){
		String url = "http://firstapp/myfirstapp"; //here logical name of application i.e. firstapp is used instead of port no.
		
		//getForObject takes 2 args - 1st arg is url and 2nd arg is response data type
		String data = template.getForObject(url, String.class);
		return ResponseEntity.status(200).body("Second app is calling "+data);
	}
	
	@GetMapping("oneMore")
	public ResponseEntity<Object> callFirstAppUsingFeignClient(){
		//getForObject takes 2 args - 1st arg is url and 2nd arg is response data type
		String data = client.invokeFirstApp();
		return ResponseEntity.status(200).body("Second app is calling through feign : "+data);
	}
	
	
}
