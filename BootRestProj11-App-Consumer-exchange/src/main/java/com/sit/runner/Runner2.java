package com.sit.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Passing Path Variables to Provider
@Component
public class Runner2 implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("Consumer app");
		System.out.println("--------------Runner2---------------");
		
		//create RestTemplate
		RestTemplate template=new RestTemplate();
		
		//Define Service Url
		String serviceUrl="http://localhost:4040/Provider/actor/wish/{id}/{name}";
		
		//Generate Http request with GET Mode to consume the Web Service(API)
		ResponseEntity<String> res=template.exchange(serviceUrl,HttpMethod.GET,null, String.class,1001,"Sairam"); 
		
		//Display the Received Details from Response
		System.out.println("Response Body(O/P) :"+res.getBody());
		System.out.println("Response Status Code value :" + res.getStatusCode().value());
	    System.out.println("Response Status Code :" + res.getStatusCode());
	    System.out.println("Response Headers :" + res.getHeaders().toString());
	}

}
