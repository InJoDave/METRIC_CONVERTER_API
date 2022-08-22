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
public class WeightConversionServiceImpl implements WeightConversionService {

	@Override
	public ConversionBean convertWeightFromTo(final String from, final double fromValue, final String to) {

		ConversionBean conversionBean = new ConversionBean();
		conversionBean.setConversionType("Weight");
		conversionBean.setFrom(from);
		conversionBean.setValue(BigDecimal.valueOf(fromValue));
		conversionBean.setTo(to);
		// Outer Switch to Select From Unit
		BigDecimal numBigDecimal;
		final String errorMessage = "Conversion from " + from + " to " + to + " is yet to be implemeted!";
		switch (from) {
		// Metric_To_Imperial
		case "mg":
			switch (to) {
			case "grain":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.0154).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "g":
			switch (to) {
			case "oz":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.0353).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "lb":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.0022).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "kg":
			switch (to) {
			case "lb":
				numBigDecimal = BigDecimal.valueOf(fromValue * 2.2046).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "tons":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.00098).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "t":
			switch (to) {
			case "tons":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.9842).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		// Imperial_To_Metric
		case "oz":
			switch (to) {
			case "g":
				numBigDecimal = BigDecimal.valueOf(fromValue * 28.35).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "lb":
			switch (to) {
			case "g":
				numBigDecimal = BigDecimal.valueOf(fromValue * 453.592).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "kg":
				numBigDecimal = BigDecimal.valueOf(fromValue * 0.4536).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "tons":
			switch (to) {
			case "kg":
				numBigDecimal = BigDecimal.valueOf(fromValue * 1016.05).stripTrailingZeros().setScale(2,
						RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "t":
				numBigDecimal = BigDecimal.valueOf(fromValue * 1.016).stripTrailingZeros().setScale(2,
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
