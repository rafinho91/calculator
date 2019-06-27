package com.calculator.model;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public enum CountryType {
	
	UK("United Kingdom", "gbp", 0.75, 600.0), 
	DE("Germany", "eur", 0.80, 800.0), 
	PL("Poland", "pln", 0.81, 1200.0);
	
	private String countryName;
	private String currency;
	private BigDecimal tax;
	private BigDecimal fixedCosts;
	
	private CountryType(String countryName, String currency, double tax, double fixedCosts) {
		this.countryName = countryName;
		this.currency = currency;
		this.tax = BigDecimal.valueOf(tax);
		this.fixedCosts = BigDecimal.valueOf(fixedCosts);
	}
	
	public static CountryType Of(String countryName) {
		for (CountryType c : CountryType.values()) {
			if (c.getCountryName().equals(countryName)) {
				return c;
			}
		}
		return null;
	}
	
	public BigDecimal calculateNetSalary(BigDecimal grossSalary) {
		BigDecimal netSalary = grossSalary.multiply(tax).subtract(fixedCosts);
		return netSalary.max(BigDecimal.valueOf(0));
	}
}
