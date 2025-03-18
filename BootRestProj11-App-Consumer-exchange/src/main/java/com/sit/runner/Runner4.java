package com.sit.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//Passing JSON Data to Provider
@Component
public class Runner4 implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Consumer app");
		System.out.println("---------------Runner4---------------");		
		
		//create RestTemplate
		RestTemplate template=new RestTemplate();

		//Define Service Url
		String serviceUrl="http://localhost:4040/Provider/actor/register";
		                   

		//prepare JSON data
		String json_body = "{"
				+ "\"aid\": 101,"
				+ "\"aname\": \"Rajesh Khanna\","
				+ "\"addrs\": \"Mumbai, Maharashtra\","
				+ "\"remuneration\": 750000.50,"
				+ "\"active_SW\": \"Yes\""
				+ "}";

		//prepare headers
		HttpHeaders headers=new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
	
		//prepare Http request as HttpEntity obj having head,body
		HttpEntity<String> entity = new HttpEntity<String>(json_body,headers);

		//Generate Http request with Post Mode to consume the Web Service(API)
		ResponseEntity<String> res=template.exchange(serviceUrl,HttpMethod.POST,entity, String.class);
		
		//Display the Received Details from Response
		System.out.println("Response Body(O/P) :"+res.getBody());
		System.out.println("Response Status Code value :" + res.getStatusCode().value());
	    System.out.println("Response Status Code :" + res.getStatusCode());
	    System.out.println("Response Headers :" + res.getHeaders().toString());

	}

}
