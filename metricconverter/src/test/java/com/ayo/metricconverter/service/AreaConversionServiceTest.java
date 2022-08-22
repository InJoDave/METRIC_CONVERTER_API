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
class AreaConversionServiceTest {

	@InjectMocks
	private AreaConversionServiceImpl areaConversionService;

	@Test
	void testConvertAreaFromTo() {
		assertEquals(BigDecimal.valueOf(1.91),
				areaConversionService.convertAreaFromTo("cm2", 12.34, "in2").getResult());
		assertEquals(BigDecimal.valueOf(14.76), areaConversionService.convertAreaFromTo("m2", 12.34, "yd2").getResult());
		assertEquals(BigDecimal.valueOf(3.05),
				areaConversionService.convertAreaFromTo("ha", 1.2345, "acre").getResult());
		assertEquals(BigDecimal.valueOf(4.97), areaConversionService.convertAreaFromTo("km2", 12.87, "mile2").getResult());
		assertEquals(BigDecimal.valueOf(82.32),
				areaConversionService.convertAreaFromTo("in2", 12.76, "cm2").getResult());
		assertEquals(BigDecimal.valueOf(0.09), areaConversionService.convertAreaFromTo("ft2", 1, "m2").getResult());
		assertEquals(BigDecimal.valueOf(0.84), areaConversionService.convertAreaFromTo("yd2", 1, "m2").getResult());
		assertEquals(BigDecimal.valueOf(300.28), areaConversionService.convertAreaFromTo("acre", 0.0742, "m2").getResult());
		assertEquals(BigDecimal.valueOf(3196.06),
				areaConversionService.convertAreaFromTo("mile2", 1234, "km2").getResult());

	}

}
