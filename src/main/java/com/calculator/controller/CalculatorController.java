package com.calculator.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.calculator.service.CalculatorService;

@RequestMapping("/calc")
@RestController
public class CalculatorController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping("/{country}")
	public ResponseEntity<String> 
		getCalculatorResponseEntity(@PathVariable ("country") String country, @RequestParam BigDecimal dailyRate) {
		
		return ResponseEntity.ok(calculatorService.getSalary(country, dailyRate).toString());
	}
	
	

}
