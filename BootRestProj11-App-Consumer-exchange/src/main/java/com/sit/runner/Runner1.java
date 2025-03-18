package com.sit.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Runner1 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Consumer app");
		System.out.println("--------------Runner1---------------");
		
		//create RestTemplate
		RestTemplate template=new RestTemplate();
		
		//Define Service Url
		String serviceUrl="http://localhost:4040/Provider/actor/wish";
		
		//Generate Http request with GET Mode to consume the Web Service(API)
		ResponseEntity<String> res=template.exchange(serviceUrl,HttpMethod.GET,null,String.class);
		
		//Display the Received Details from Response
		System.out.println("Response Body(O/P) :"+res.getBody());
		System.out.println("Response Status Code value :" + res.getStatusCode().value());
	    System.out.println("Response Status Code :" + res.getStatusCode());
	}

}
