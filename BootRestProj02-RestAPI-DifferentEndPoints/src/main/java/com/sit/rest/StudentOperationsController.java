package com.sit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("student-api")
public class StudentOperationsController {

	
	//API End Points
	
	@GetMapping("/report")
	public ResponseEntity<String> showReport(){
		System.out.println("StudentOperationsController.showReport()");
		return new ResponseEntity<String>("Report Generation Process",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerStudent(){
		System.out.println("StudentOperationsController.registerStudent()");
		return new ResponseEntity<String>("Student Registration Process",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> editStudent(){
		System.out.println("StudentOperationsController.editStudent()");
		return new ResponseEntity<String>("student edit Process",HttpStatus.OK);
	}
	
	@PatchMapping("/emailUpdate")
	public ResponseEntity<String> editStudentEmail(){
		System.out.println("StudentOperationsController.editStudent()");
		return new ResponseEntity<String>("student Email updated",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteStudent(){
		System.out.println("StudentOperationsController.editStudent()");
		return new ResponseEntity<String>("student deletion process",HttpStatus.OK);
	}
	
}
