package com.calculator.model;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public enum CountryType {
	
	UK("gbp", 0.75, 600.0), 
	DE("eur", 0.80, 800.0), 
	PL("pln", 0.81, 1200.0);
	
	private String currency;
	private BigDecimal tax;
	private BigDecimal fixedCosts;
	
	private CountryType(String currency, double tax, double fixedCosts) {
		this.currency = currency;
		this.tax = BigDecimal.valueOf(tax);
		this.fixedCosts = BigDecimal.valueOf(fixedCosts);
	}
	
	public BigDecimal calculateNetSalary(BigDecimal grossSalary) {
		BigDecimal netSalary = grossSalary.multiply(tax).subtract(fixedCosts);
		return netSalary.max(BigDecimal.valueOf(0));
	}
}
