package com.sit.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class Runner5 implements CommandLineRunner{
	
	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		

		System.out.println("---deleteById---");

		String Url="http://localhost:4040/RestMiniProject/tourist/delete/{id}";
		
		template.delete(Url, 959);

		System.out.println("Result r5 : ");
		System.out.println("Tourist Deleted");
	}
	
	

}
