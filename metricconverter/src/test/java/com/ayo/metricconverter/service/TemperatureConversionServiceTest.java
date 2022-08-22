package com.ayo.metricconverter.service;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 * 
 * @author Indu John
 *
 */
@ExtendWith(MockitoExtension.class)
class TemperatureConversionServiceTest {

	@InjectMocks
	private TemperatureConversionServiceImpl temperatureConversionService;

	@Test
	void convertTemperatureFromTo() {
		assertEquals(BigDecimal.valueOf(54.21),
				temperatureConversionService.convertTemperatureFromTo("c", 12.34, "f").getResult());
		assertEquals(BigDecimal.valueOf(12.34),
				temperatureConversionService.convertTemperatureFromTo("f", 54.21, "c").getResult());
	}

}
