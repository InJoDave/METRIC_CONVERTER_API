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
class WeightConversionServiceTest {

	@InjectMocks
	private WeightConversionServiceImpl weightConversionService;

	@Test
	void convertWeightFromTo() {
		assertEquals(BigDecimal.valueOf(0.02),
				weightConversionService.convertWeightFromTo("mg", 1, "grain").getResult());
		assertEquals(BigDecimal.valueOf(0.04),
				weightConversionService.convertWeightFromTo("g", 1, "oz").getResult());
		
		assertEquals(BigDecimal.valueOf(0.27),
				weightConversionService.convertWeightFromTo("g", 123, "lb").getResult());
		assertEquals(BigDecimal.valueOf(22.05),
				weightConversionService.convertWeightFromTo("kg", 10, "lb").getResult());
		assertEquals(BigDecimal.valueOf(1.21),
				weightConversionService.convertWeightFromTo("kg", 1234, "tons").getResult());
		assertEquals(BigDecimal.valueOf(0.98),
				weightConversionService.convertWeightFromTo("t", 1, "tons").getResult());
		assertEquals(BigDecimal.valueOf(28.35),
				weightConversionService.convertWeightFromTo("oz", 1, "g").getResult());
		assertEquals(BigDecimal.valueOf(453.59),
				weightConversionService.convertWeightFromTo("lb", 1, "g").getResult());
		assertEquals(BigDecimal.valueOf(0.45),
				weightConversionService.convertWeightFromTo("lb", 1, "kg").getResult());
		assertEquals(BigDecimal.valueOf(1016.05),
				weightConversionService.convertWeightFromTo("tons", 1, "kg").getResult());
		assertEquals(BigDecimal.valueOf(1.02),
				weightConversionService.convertWeightFromTo("tons", 1, "t").getResult());
	}

}
