package com.sit.rest;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.model.Faculty;
import com.sit.model.Farmer;

@RestController
@RequestMapping("/faculty-api")
public class FacultyOperationsController {

	@PostMapping("/register-faculty")
	public ResponseEntity<String> showReport(@RequestBody Faculty fac){
	
		return new ResponseEntity<String>(fac.toString(),HttpStatus.OK);
	}

	@PostMapping("/register-faculties")
	public ResponseEntity<String> showReport2(@RequestBody List<Faculty> list){

		return new ResponseEntity<String>(list.toString(),HttpStatus.OK);
	}
	

	@PostMapping("/register-farmer")
	public String showReport3(@RequestBody Farmer farmer){
		
		return farmer.toString();
	}

}
