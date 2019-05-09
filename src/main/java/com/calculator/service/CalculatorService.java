package com.calculator.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.calculator.model.Currency;

@Service
public class CalculatorService {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Currency getCurrencyRate(String currency) {
		return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/" 
				+ currency.toLowerCase() + "?format=json", Currency.class);
	}

}
