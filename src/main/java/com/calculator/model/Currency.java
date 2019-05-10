package com.calculator.model;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Currency {

	@JsonProperty("currency")
	private String name;
	
	private String code;
	private Rate[] rates;
	
	public BigDecimal getCurrencyRate() {
		if("pln".equals(code)) {
			return BigDecimal.valueOf(1);
		}
		return rates[0].getValue();
	}
	
}
