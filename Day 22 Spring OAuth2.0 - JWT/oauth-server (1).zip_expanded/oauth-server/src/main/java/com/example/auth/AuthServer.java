package com.example.auth;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthServer {

	//This method is executed when microservice sends the token to authserver for verification
	//an endpoint the microservice would use to send the token, this method would receive it and send ack
	@GetMapping(value ="/user", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String ,Object> user(OAuth2Authentication token){
		Map<String,Object> userInfo = new HashMap<String,Object>();
		userInfo.put("user",token.getUserAuthentication().getPrincipal());
		userInfo.put("authorities", token.getUserAuthentication().getAuthorities());
		return userInfo;
	}
	
}
