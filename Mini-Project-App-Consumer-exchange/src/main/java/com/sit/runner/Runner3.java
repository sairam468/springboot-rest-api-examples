package com.sit.runner;

import java.net.http.HttpHeaders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Runner3 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("---register---");
		
		String Url="http://localhost:4040/RestMiniProject/tourist/register";
		String json_body = "{"
			    + "\"name\": \"Rohit Sharma\","
			    + "\"city\": \"Mumbai\","
			    + "\"packageType\": \"Premium\","
			    + "\"budget\": 1500.50"
			    + "}";
		org.springframework.http.HttpHeaders headers=new org.springframework.http.HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json_body,headers);
		
		ResponseEntity<String> result = template.exchange(Url,HttpMethod.POST, entity, String.class);
		
		System.out.println("Result r3 : "+result);
		System.out.println("Response Body : "+result.getBody());
		System.out.println("Response Headers : "+result.getHeaders());
		System.out.println("Response Status Code : "+result.getStatusCode().value());
		
	}
	
	

}
