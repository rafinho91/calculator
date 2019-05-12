package com.calculator.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CountryTypeTests {
	
	BigDecimal INCOME = BigDecimal.valueOf(5000);
	
	@Test
	public void calculateNetSalaryTest() {
		CountryType poland = CountryType.PL;
		CountryType germany = CountryType.DE;
		CountryType uk = CountryType.UK;
		
		assertThat(poland.calculateNetSalary(INCOME)).isEqualByComparingTo(BigDecimal.valueOf(2850));
		assertThat(germany.calculateNetSalary(INCOME)).isEqualByComparingTo(BigDecimal.valueOf(3200));
		assertThat(uk.calculateNetSalary(INCOME)).isEqualByComparingTo(BigDecimal.valueOf(3150));
	}

}
