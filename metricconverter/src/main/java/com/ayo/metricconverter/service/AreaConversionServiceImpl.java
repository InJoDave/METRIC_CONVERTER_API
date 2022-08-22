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
public class AreaConversionServiceImpl implements AreaConversionService {

	@Override
	public ConversionBean convertAreaFromTo(final String from, final double fromValue, final String to) {

		ConversionBean conversionBean = new ConversionBean();
		conversionBean.setConversionType("Area");
		conversionBean.setFrom(from);
		conversionBean.setValue(BigDecimal.valueOf(fromValue));
		conversionBean.setTo(to);
		// Outer Switch to Select From Unit
		BigDecimal numBigDecimal;
		final String errorMessage = "Conversion from " + from + " to " + to + " is yet to be implemeted!";
		switch (from) {
		// Metric_To_Imperial
		case "cm2":
			switch (to) {
			case "in2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.1550).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "m2":
			switch (to) {
			case "yd2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 1.1960).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "ha":
			switch (to) {
			case "acre":
				numBigDecimal = BigDecimal.valueOf(fromValue * 2.4711).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "km2":
			switch (to) {
			case "mile2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.3861).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		// Imperial_To_Metric
		case "in2":
			switch (to) {
			case "cm2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 6.4516).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "ft2":
			switch (to) {
			case "m2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.0929).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "yd2":
			switch (to) {
			case "m2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.8361).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "acre":
			switch (to) {
			case "m2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 4046.9).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "mile2":
			switch (to) {
			case "km2":
				numBigDecimal = BigDecimal.valueOf(fromValue * 2.59).stripTrailingZeros().setScale(2,
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
