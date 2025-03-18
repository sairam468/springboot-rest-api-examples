 package com.sit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path-api")
public class RequestParamRestController {

	@GetMapping("/report/{sno}/{sname}")
	public ResponseEntity<String> showData(@PathVariable("sno") int no,@PathVariable String sname){
		System.out.println(no+"...."+sname);
		return new ResponseEntity<String>(no+"...."+sname,HttpStatus.OK);
	}
	
	@GetMapping({"/report1/{sno}/{sname}","/report1/{sno}","/report1"})
	public ResponseEntity<String> showData1(@PathVariable(value="sno",required=false) Integer no,@PathVariable(required=false) String sname){
		System.out.println(no+"...."+sname);
		return new ResponseEntity<String>(no+"...."+sname,HttpStatus.OK);
	}
}
