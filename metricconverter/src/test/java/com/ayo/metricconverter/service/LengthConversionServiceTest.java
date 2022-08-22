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
class LengthConversionServiceTest {

	@InjectMocks
	private LengthConversionServiceImpl lengthConversionService;

	@Test
	void testConvertLengthFromTo() {
		assertEquals(BigDecimal.valueOf(12.34), lengthConversionService.convertLengthFromTo("cm", 1.234, "mm").getResult());
		assertEquals(BigDecimal.valueOf(0.39), lengthConversionService.convertLengthFromTo("cm", 1, "in").getResult());
		assertEquals(BigDecimal.valueOf(123.45), lengthConversionService.convertLengthFromTo("m", 1.2345, "cm").getResult());
		assertEquals(BigDecimal.valueOf(1.09), lengthConversionService.convertLengthFromTo("m", 1, "yd").getResult());
		assertEquals(BigDecimal.valueOf(123.45), lengthConversionService.convertLengthFromTo("km", 0.12345, "m").getResult());
		assertEquals(BigDecimal.valueOf(0.62), lengthConversionService.convertLengthFromTo("km", 1, "mi").getResult());
		assertEquals(BigDecimal.valueOf(0.04), lengthConversionService.convertLengthFromTo("mm", 1, "in").getResult());
		assertEquals(BigDecimal.valueOf(2.54), lengthConversionService.convertLengthFromTo("in", 1, "cm").getResult());
		assertEquals(BigDecimal.valueOf(376.12), lengthConversionService.convertLengthFromTo("ft", 1234, "m").getResult());
		assertEquals(BigDecimal.valueOf(148.08), lengthConversionService.convertLengthFromTo("ft", 12.34, "in").getResult());
		assertEquals(BigDecimal.valueOf(37.02), lengthConversionService.convertLengthFromTo("yd", 12.34, "ft").getResult());
		assertEquals(BigDecimal.valueOf(0.91), lengthConversionService.convertLengthFromTo("yd", 1, "m").getResult());
		assertEquals(BigDecimal.valueOf(217.18), lengthConversionService.convertLengthFromTo("mi", 0.1234, "yd").getResult());
		assertEquals(BigDecimal.valueOf(1.61), lengthConversionService.convertLengthFromTo("mi", 1, "km").getResult());
	}

}
