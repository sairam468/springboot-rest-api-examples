package com.sit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

//@Component
public class Runner5 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		

		System.out.println("---deleteById---");

		String Url="http://localhost:4040/RestMiniProject/tourist/delete/{id}";
		
		ResponseEntity<String> result = template.exchange(Url,HttpMethod.DELETE, null,String.class,2952);

		System.out.println("Result r5 : ");
		System.out.println("Tourist Deleted");
		
		System.out.println("Result r3 : "+result);
		System.out.println("Response Body : "+result.getBody());
		System.out.println("Response Headers : "+result.getHeaders());
		System.out.println("Response Status Code : "+result.getStatusCode().value());

	}
	
	

}
