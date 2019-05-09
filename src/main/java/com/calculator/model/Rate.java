package com.calculator.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Rate {
	
	@JsonProperty("effectiveDate")
	private String date;
	
	@JsonProperty("mid")
	private Double value;

}
