package com.calculator.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculator.model.Currency;
import com.calculator.model.Rate;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CalculatorServiceTests {

	@InjectMocks
	private CalculatorService calculatorService;
	
	@Mock
	CurrencyRepository mockedRepository;
	
	@Test
	public void getSalaryTest() {
		Rate[] rates = {Rate.builder().value(BigDecimal.valueOf(4.30)).build()};
 		
		Mockito
			.when(mockedRepository.getCurrency("eur"))
			.thenReturn(Currency.builder().name("euro").code("eur").rates(rates).build());
		
		assertThat(calculatorService.getSalary("Germany", BigDecimal.valueOf(500))).isEqualByComparingTo(BigDecimal.valueOf(34400));
	}
}
