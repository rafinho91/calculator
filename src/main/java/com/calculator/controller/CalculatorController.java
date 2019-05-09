package com.calculator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.service.CalculatorService;

@RequestMapping("/calc")
@RestController
public class CalculatorController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping("/{currencyType}")
	public ResponseEntity<String> getCalculatoResponseEntity(@PathVariable ("currencyType") String currencyType) {
		
		return ResponseEntity.ok(calculatorService.getCurrencyRate(currencyType).toString());
	}
	
	

}
