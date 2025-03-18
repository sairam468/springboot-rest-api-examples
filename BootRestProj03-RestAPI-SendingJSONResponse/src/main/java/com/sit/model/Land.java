package com.sit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Land {

	private Integer pbno;
	private String landArea;
	private String village;
	private String type;
}
