package com.sit.rest;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sit.model.Faculty;
import com.sit.model.Farmer;
import com.sit.model.Land;

@RestController
@RequestMapping("/faculty-api")
public class FacultyOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Faculty> showReport(){
		Faculty fac=new Faculty();
		fac.setFid(1001);
		fac.setFname("Sai");
		fac.setQlfy("BTech");
		fac.setSubject("Java full stack");
		fac.setAddrs("Bvrm");

		return new ResponseEntity<Faculty>(fac,HttpStatus.OK);
	}
	
	@GetMapping("/report2")
	public ResponseEntity<List<Faculty>> showReport2(){
		Faculty fac=new Faculty();
		fac.setFid(1001);
		fac.setFname("Sai");
		fac.setQlfy("BTech");
		fac.setSubject("Java full stack");
		fac.setAddrs("Bvrm");
		
		Faculty fac1=new Faculty();
		fac1.setFid(1002);
		fac1.setFname("ram");
		fac1.setQlfy("BTech");
		fac1.setSubject("Python full stack");
		fac1.setAddrs("Bvrm");

		return new ResponseEntity<List<Faculty>>(List.of(fac,fac1),HttpStatus.OK);
	}
	

	@GetMapping("/report3")
	public ResponseEntity<Farmer> showReport3(){
		//Create obj
		Land land =new Land(12010,"100Acers","Koamarada","wet");


		Farmer farmer=new Farmer(2001, "Sai", "Bvrm", new String[] {"red","green","Yellow"},true,"paddy",List.of("sai","ganta"),Set.of(7032054842L,6302009029L),Map.of("aadhaar",456465,"voterId",4789479), land);

		//return ResponseEntity obj
		return new ResponseEntity<Farmer>(farmer,HttpStatus.OK);
	}
}
