package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service.ServiceForSecondApp;


@RestController
@RequestMapping("secondapp")
public class SecondController {
	
	@Autowired
	private ServiceForSecondApp service;

	@GetMapping("/callFirstApp")
	public ResponseEntity<Object> callFirstAppFeign(){
		return ResponseEntity.status(200).body("Second app calling : "+service.getFirstAppDataFromSecondApp());
	}
}
