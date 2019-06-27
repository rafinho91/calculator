package com.calculator.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.calculator.model.CountryType;
import com.calculator.model.Currency;
import com.calculator.model.CurrencyDTO;

@Service
public class CalculatorService {
	
	private int NUMBER_OF_DAYS_IN_MONTH = 22;
	
	private CurrencyRepository currencyRepository;
	
	@Autowired
	public CalculatorService(CurrencyRepository currencyRepository) {
		this.currencyRepository = currencyRepository;
	}
	
	public BigDecimal getSalary(String country, BigDecimal dailyRate) {
		CountryType countryType = CountryType.Of(country);	
		Currency currency = currencyRepository.getCurrency(countryType.getCurrency());
		return calculateSalary(countryType, currency.getCurrencyRate(), dailyRate);
	}
	
	public List<CurrencyDTO> getAvailableCurrencies() {
		List<CurrencyDTO> listOfCurrencyRates = new ArrayList<>();
		for (Currency cur : currencyRepository.getAvailableCurrencies()) {
			listOfCurrencyRates.add(new CurrencyDTO(cur));
		}
		return listOfCurrencyRates;
	}

	private BigDecimal calculateSalary(CountryType countryType, BigDecimal currencyRate, BigDecimal dailyRate) {
		BigDecimal grossSalary = dailyRate.multiply(BigDecimal.valueOf(NUMBER_OF_DAYS_IN_MONTH));
		return countryType.calculateNetSalary(grossSalary).multiply(currencyRate);
	}
}
