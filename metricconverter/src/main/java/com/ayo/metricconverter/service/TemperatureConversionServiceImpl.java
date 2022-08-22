package com.ayo.metricconverter.service;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.stereotype.Service;

import com.ayo.metricconverter.entity.ConversionBean;
import com.ayo.metricconverter.exception.NoSuchConversionExistsException;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Indu John
 *
 */
@Service
@Slf4j
public class TemperatureConversionServiceImpl implements TemperatureConversionService {
	@Override
	public ConversionBean convertTemperatureFromTo(final String from, final double fromValue, final String to) {

		ConversionBean conversionBean = new ConversionBean();
		conversionBean.setConversionType("Temperature");
		conversionBean.setFrom(from);
		conversionBean.setValue(BigDecimal.valueOf(fromValue));
		conversionBean.setTo(to);
		// Outer Switch to Select From Unit
		BigDecimal numBigDecimal;
		final String errorMessage = "Conversion from " + from + " to " + to + " is yet to be implemeted!";
		switch (from) {
		// Metric_To_Imperial (From Celsius into Fahrenheit)
		case "c":
			switch (to) {
			case "f":
				numBigDecimal = BigDecimal.valueOf((fromValue * 1.8) + 32).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		// Imperial_To_Metric (From Fahrenheit to Celsius)
		case "f":
			switch (to) {
			case "c":
				numBigDecimal = BigDecimal.valueOf((fromValue - 32) / 1.8).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;

		default:
			throw new NoSuchConversionExistsException(errorMessage);
		}
		return conversionBean;
	}
}
