package com.calculator.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.calculator.model.CountryType;
import com.calculator.model.Currency;

@Repository
public class CurrencyRepository {
	
	private final String NBP_API = "http://api.nbp.pl/api/exchangerates/rates/a/";
	
	@Autowired
	RestTemplate restTemplate;
	
	public Currency getCurrency(String currency) {
		if ("pln".equals(currency)) {
			return Currency.builder().name("zł").code("pln").build();
		}
		return restTemplate.getForObject(NBP_API + currency.toLowerCase() + "?format=json", Currency.class);
	};
	
	public List<Currency> getAvailableCurrencies() {
		List<Currency> currencies = new ArrayList<>();
		for (CountryType country : CountryType.values()) {
			if (country.getCurrency() != "pln") {
				currencies.add(getCurrency(country.getCurrency()));
			}
		}
		return currencies;
	};

}
