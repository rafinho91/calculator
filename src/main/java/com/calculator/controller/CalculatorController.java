package com.calculator.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.service.CalculatorService;
import com.calculator.model.CurrencyDTO;

@RequestMapping("/calc")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CalculatorController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping("/{country}")
	public ResponseEntity<String> 
		getCalculatorResponseEntity(@PathVariable ("country") String country, @RequestParam BigDecimal dailyIncome) {
		
		return ResponseEntity.ok(calculatorService.getSalary(country, dailyIncome).toString());
	}
	
	@GetMapping("/currencies")
	public List<CurrencyDTO> getAvailableCurrencies() {
		return calculatorService.getAvailableCurrencies();
	}
	
	

}
