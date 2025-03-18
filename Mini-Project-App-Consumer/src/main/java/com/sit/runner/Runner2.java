package com.sit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Runner2 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("---findById---");
		
		String Url="http://localhost:4040/RestMiniProject/tourist/findById/{id}";
		
		ResponseEntity<String> result=template.getForEntity(Url, String.class,1952);
		
		System.out.println("Result r2 : "+result);
		System.out.println("Response Body : "+result.getBody());
		System.out.println("Response Headers : "+result.getHeaders());
		System.out.println("Response Status Code : "+result.getStatusCode().value());
		
	}
	
	

}
