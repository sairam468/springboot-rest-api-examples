package com.sit.model;

import java.time.LocalDate;

import lombok.Data;

@Data
public class Faculty {

	private Integer fid;
	private String fname;
	private String qlfy;
	private String subject;
	private String addrs;
	private LocalDate dob;
}
