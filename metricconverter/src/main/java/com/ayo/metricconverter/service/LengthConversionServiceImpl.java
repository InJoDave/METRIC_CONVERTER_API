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
public class LengthConversionServiceImpl implements LengthConversionService{

	@Override
	public ConversionBean convertLengthFromTo(final String from, final double fromValue, final String to) {

		ConversionBean conversionBean = new ConversionBean();
		conversionBean.setConversionType("Length");
		conversionBean.setFrom(from);
		conversionBean.setValue(BigDecimal.valueOf(fromValue));
		conversionBean.setTo(to);
		//		Outer Switch to Select From Unit
		BigDecimal numBigDecimal;
		final String errorMessage = "Conversion from "+ from+" to "+to+" is yet to be implemeted!";
		switch (from) {
		//		Metric_To_Imperial
		case "cm":
			switch (to) {
//			case "mm":
//				numBigDecimal = BigDecimal.valueOf(fromValue*10).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
//				conversionBean.setResult(numBigDecimal);
//				break;
			case "in":
				numBigDecimal = BigDecimal.valueOf(fromValue*0.3937).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "m":
			switch (to) {
			case "cm":
				numBigDecimal = BigDecimal.valueOf(fromValue*100).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "yd":
				numBigDecimal = BigDecimal.valueOf(fromValue*1.0936).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "km":
			switch (to) {
			case "m":
				numBigDecimal = BigDecimal.valueOf(fromValue*1000).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "mi":
				numBigDecimal = BigDecimal.valueOf(fromValue*0.6214).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "mm":
			switch (to) {
			case "in":
				numBigDecimal = BigDecimal.valueOf(fromValue*0.03937).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
			//		Imperial_To_Metric
		case "in":
			switch (to) {
			case "cm":
				numBigDecimal = BigDecimal.valueOf(fromValue*2.54).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "ft":
			switch (to) {
			case "m":
				numBigDecimal = BigDecimal.valueOf(fromValue*0.3048).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "in":
				numBigDecimal = BigDecimal.valueOf(fromValue*12).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "yd":
			switch (to) {
			case "ft":
				numBigDecimal = BigDecimal.valueOf(fromValue*3).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "m":
				numBigDecimal = BigDecimal.valueOf(fromValue*0.9144).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			default:
				throw new NoSuchConversionExistsException(errorMessage);
			}
			break;
		case "mi":
			switch (to) {
			case "yd":
				numBigDecimal = BigDecimal.valueOf(fromValue*1760).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
				conversionBean.setResult(numBigDecimal);
				break;
			case "km":
				numBigDecimal = BigDecimal.valueOf(fromValue*1.6093).stripTrailingZeros().setScale(2, RoundingMode.HALF_EVEN);
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
