package com.sit.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Tourist {

	

	private Integer tid;

	private String name;

	private String city;
	
	private String packageType;
	
	private Double budget;
	
}
