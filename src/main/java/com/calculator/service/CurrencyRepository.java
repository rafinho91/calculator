package com.calculator.service;

import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.calculator.model.Currency;

@Repository
public class CurrencyRepository {
	
	private RestTemplate restTemplate = new RestTemplate();
	
	public Currency getCurrency(String currency) {
		if ("pln".equals(currency)) {
			return Currency.builder().name("zł").code("pln").build();
		}
		return restTemplate.getForObject("http://api.nbp.pl/api/exchangerates/rates/a/" 
				+ currency.toLowerCase() + "?format=json", Currency.class);
	}

}
