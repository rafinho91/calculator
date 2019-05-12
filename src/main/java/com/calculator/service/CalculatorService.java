package com.calculator.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.model.CountryType;
import com.calculator.model.Currency;

@Service
public class CalculatorService {
	
	private int NUMBER_OF_DAYS_IN_MONTH = 22;
	private CurrencyRepository currencyRepository;
	
	@Autowired
	public CalculatorService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}
	
	public BigDecimal getSalary(String country, BigDecimal dailyRate) {
		CountryType countryType;
		try {
			countryType = CountryType.valueOf(country.toUpperCase());
		}
		catch (Exception e) {
			countryType = CountryType.PL;
		}	
		Currency currency = currencyRepository.getCurrency(countryType.getCurrency());
		return calculateSalary(countryType, currency.getCurrencyRate(), dailyRate);
	}

	private BigDecimal calculateSalary(CountryType countryType, BigDecimal currencyRate, BigDecimal dailyRate) {
		BigDecimal grossSalary = dailyRate.multiply(BigDecimal.valueOf(NUMBER_OF_DAYS_IN_MONTH));
		return countryType.calculateNetSalary(grossSalary).multiply(currencyRate);
	}
}
