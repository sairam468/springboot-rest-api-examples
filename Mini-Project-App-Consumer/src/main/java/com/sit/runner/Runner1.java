package com.sit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Runner1 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("---findAll---");
		
		String Url="http://localhost:4040/RestMiniProject/tourist/findAll";
		
		String result=template.getForObject(Url, String.class);
		System.out.println("Result r1 : "+result);
	}
	
	

}
