package com.sit.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sit.entity.Tourist;

@Component
public class Runner1 implements CommandLineRunner{

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {

		System.out.println("---findAll---");

		String Url="http://localhost:4040/RestMiniProject/tourist/findAll";

		//Generate Http request with GET Mode to consume the Web Service(API)
		ResponseEntity<String> res=template.exchange(Url,HttpMethod.GET,null,String.class);

		//Display the Received Details from Response
		System.out.println("Response Body(O/P) :"+res.getBody());
		System.out.println("Response Status Code value :" + res.getStatusCode().value());
		System.out.println("Response Status Code :" + res.getStatusCode());

		System.out.println("---------------------------------------------");

		//Converting JSPN text response(body) to java class model object using JACKSON api
		String jsonBody=res.getBody();

		//create ObjectMapper
		ObjectMapper mapper=new ObjectMapper();

		List<Tourist> tourists = mapper.readValue(jsonBody, new TypeReference<List<Tourist>>() {});


		tourists.forEach(System.out::println);
	}


}
