package com.sit.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.binding.Actor;

@RestController
@RequestMapping("/actor")
public class ActionOperationsController {

	//Passing Path Variables to Provider
	@GetMapping("/wish/{id}/{name}")
	public ResponseEntity<String> displayWishMessage(@PathVariable Integer id,@PathVariable String name){
		return new ResponseEntity<String>("Good Morning :: "+id+"...."+name,HttpStatus.OK);
	}
	
	
	//Passing JSON Data to Provider
	@PostMapping("/register")
	public ResponseEntity<String> registerActor(@RequestBody Actor actor){
		return new ResponseEntity<String>("Actor Data :: "+actor.toString(),HttpStatus.OK);
	}
	
	//Getting JSON reponse to consumer
	@GetMapping("/report")
	public ResponseEntity<Actor> reportActorData(){
		Actor a=new Actor(1001,"Sairam", "BVRM",20000.0,"Yes");
		return new ResponseEntity<Actor>(a,HttpStatus.OK);
	}
	
}
