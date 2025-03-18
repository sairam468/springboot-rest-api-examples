package com.sit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.sit.entity.Tourist;
import com.sit.service.ITouristMgmtService;

@RestController
@RequestMapping("/tourist")
public class TouristoperationsController {
	
	@Autowired
	private ITouristMgmtService service;
	
	@PostMapping("/register")
	public ResponseEntity<String> enrollTourist(@RequestBody Tourist tourist){
		try {
			String result=service.registerTourist(tourist);
			return new ResponseEntity<String>(result,HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("problem in tourist enrollement",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<?> displayTourist()
	{
		try {
			List<Tourist> fetchAll = service.fetchAll();
			return new ResponseEntity<List<Tourist>>(fetchAll,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("problem in tourist enrollement",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findAll/{city1}/{city2}/{city3}")
	public ResponseEntity<?> displayTouristByCities(@PathVariable(required=false)String city1,@PathVariable(required=false)String city2,@PathVariable(required=false)String city3)
	{
		try {
			List<Tourist> l = service.showAllTourist(city1, city2, city3);
			return new ResponseEntity<List<Tourist>>(l,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>("problem in tourist enrollement",HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/findById/{id}")
	public ResponseEntity<?> displayTouristByID(@PathVariable(required=false)Integer id)
	{
		try {
			Tourist t = service.fetchById(id);
			return new ResponseEntity<Tourist>(t,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modify")
	public ResponseEntity<String> modifyTourist(@RequestBody Tourist t){
		try {
			String m = service.updateTourist(t);
			return new ResponseEntity<String>(m,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	
	@GetMapping("/findByName/{name}")
	public ResponseEntity<?> displayTouristByName(@PathVariable String name)
	{
		try {
			List<Tourist> showTouristByName = service.showTouristByName(name);
			return new ResponseEntity<List<Tourist>>(showTouristByName,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PatchMapping("/update/{id}/{percentage}")
	public ResponseEntity<?> modifyTouristBudgetById(@PathVariable Integer id,@PathVariable Double percentage){
		try {
			String m = service.updateTouristById(id, percentage);
			return new ResponseEntity<String>(m,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteTouristById(@PathVariable Integer id){
		try {
			String removeTouristById = service.removeTouristById(id);
			return new ResponseEntity<String>(removeTouristById,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/delete/{start}/{end}")
	public ResponseEntity<?> deleteTouristByBudgetRange(@PathVariable Double start,@PathVariable Double end){
		try {
			String m = service.removeTouristByBudgetRange(start, end);
			return new ResponseEntity<String>(m,HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

