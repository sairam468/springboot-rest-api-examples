package com.sit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sit.entity.Tourist;

@Component
public class Runner2 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	//@Override
	public void run(String... args) throws Exception {
		
		
		System.out.println("---findById---");
		
		String Url="http://localhost:4040/RestMiniProject/tourist/findById/{id}";

		//Generate Http request with GET Mode to consume the Web Service(API)
		ResponseEntity<String> res=template.exchange(Url,HttpMethod.GET,null,String.class,1952);
		
		//Display the Received Details from Response
		System.out.println("Response Body(O/P) :"+res.getBody());
		System.out.println("Response Status Code value :" + res.getStatusCode().value());
	    System.out.println("Response Status Code :" + res.getStatusCode());
	    
	    System.out.println("---------------------------------------------");
	    
	    //Converting JSPN text response(body) to java class model object using JACKSON api
	    String jsonBody=res.getBody();
	    
	    //create ObjectMapper
	    ObjectMapper mapper=new ObjectMapper();
	    
	    Tourist a=mapper.readValue(jsonBody,//body
	    		 Tourist.class);             //required object type
	    
	    System.out.println("response body as  Tourist object data :"+a);
	}
	
	

}
