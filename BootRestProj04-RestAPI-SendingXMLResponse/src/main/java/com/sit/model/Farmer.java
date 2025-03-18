package com.sit.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Farmer {

	private Integer fid;
	private String name;
	private String addrs;
	private String[] colors;
	private boolean indian;
	private String cropname;
	private List<String> nicknames;
	private Set<Long> phoneNumbers;
	private Map<String,Object> idDetails;
	private Land landdeatails;
}
