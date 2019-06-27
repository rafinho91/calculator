package com.calculator.model;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CurrencyDTO {

	private String name;
	private BigDecimal rate;

	public CurrencyDTO(Currency currency) {
		this.name = currency.getName();
		this.rate = currency.getCurrencyRate();
	}
	
}
