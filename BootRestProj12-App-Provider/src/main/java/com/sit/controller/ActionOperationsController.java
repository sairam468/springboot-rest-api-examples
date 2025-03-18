package com.sit.controller;

import java.util.List;

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
	
	@GetMapping("/find")
	public ResponseEntity<Actor> searchActor(){
		return new ResponseEntity<Actor>(new Actor(1001,"Sairam", "BVRM",20000.0,"Yes"),HttpStatus.OK);
	}


	@GetMapping("/findAll")
	public ResponseEntity<List<Actor>> searchAllActors(){
		List<Actor> l=List.of(new Actor(1001,"Sairam", "BVRM",20000.0,"Yes"),new Actor(1002,"Virat", "Mumbai",20000.0,"Yes"),new Actor(1001,"Rohit", "Mumbai",20000.0,"Yes"));
		return new ResponseEntity <List<Actor>>(l,HttpStatus.OK);
	}
}
