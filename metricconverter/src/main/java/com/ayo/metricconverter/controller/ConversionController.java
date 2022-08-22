package com.ayo.metricconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayo.metricconverter.entity.ConversionBean;
import com.ayo.metricconverter.service.AreaConversionService;
import com.ayo.metricconverter.service.LengthConversionService;
import com.ayo.metricconverter.service.TemperatureConversionService;
import com.ayo.metricconverter.service.WeightConversionService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * @author Indu John
 *
 */
@RestController
@RequestMapping("/convert")
@Slf4j
public class ConversionController {

	@Autowired
	LengthConversionService lengthConversionService;

	@Autowired
	TemperatureConversionService temperatureConversionService;

	@Autowired
	WeightConversionService weightConversionService;
	
	@Autowired
	AreaConversionService areaConversionService;

	/**
	 * Return the details of conversion for Length Default conversion has been set
	 * from cm to mm
	 * 
	 * @param fromUnit
	 * @param size
	 * @param toUnit
	 * @return
	 */
	@GetMapping("/length")
	public ResponseEntity<ConversionBean> getLengthConvertedFromTo(
			@RequestParam(required = true, name = "fromUnit", defaultValue = "cm") String fromUnit,
			@RequestParam(required = true, name = "valueToConvert") Double valueToConvert,
			@RequestParam(required = true, name = "toUnit", defaultValue = "in") String toUnit) {
		if (valueToConvert == null) {
			throw new IllegalArgumentException("Parameter valueToConvert is Empty");
		} else {
			final ConversionBean conversionBean = lengthConversionService.convertLengthFromTo(fromUnit, valueToConvert,
					toUnit);
			return ResponseEntity.ok(conversionBean);
		}
	}

	/**
	 * Return the details of conversion for Length Default conversion has been set
	 * from celsius to fahrenheit
	 * 
	 * @param fromUnit
	 * @param valueToConvert
	 * @param toUnit
	 * @return
	 */
	@GetMapping("/temperature")
	public ResponseEntity<ConversionBean> getTemperatureConvertedFromTo(
			@RequestParam(required = true, name = "fromUnit", defaultValue = "c") String fromUnit,
			@RequestParam(required = true, name = "valueToConvert") Double valueToConvert,
			@RequestParam(required = true, name = "toUnit", defaultValue = "f") String toUnit) {
		if (valueToConvert == null) {
			throw new IllegalArgumentException("Parameter valueToConvert is Empty");
		} else {
			final ConversionBean conversionBean = temperatureConversionService.convertTemperatureFromTo(fromUnit,
					valueToConvert, toUnit);
			return ResponseEntity.ok(conversionBean);
		}
	}
	
	/**
	 * Return the details of conversion for Weight Default conversion has been set
	 * from grams to ounce
	 * 
	 * @param fromUnit
	 * @param valueToConvert
	 * @param toUnit
	 * @return
	 */
	@GetMapping("/weight")
	public ResponseEntity<ConversionBean> getWeightConvertedFromTo(
			@RequestParam(required = true, name = "fromUnit", defaultValue = "g") String fromUnit,
			@RequestParam(required = true, name = "valueToConvert") Double valueToConvert,
			@RequestParam(required = true, name = "toUnit", defaultValue = "oz") String toUnit) {
		if (valueToConvert == null) {
			throw new IllegalArgumentException("Parameter valueToConvert is Empty");
		} else {
			final ConversionBean conversionBean = weightConversionService.convertWeightFromTo(fromUnit,
					valueToConvert, toUnit);
			return ResponseEntity.ok(conversionBean);
		}
	}
	
	/**
	 * Return the details of conversion for Area Default conversion has been set
	 * from sq cm to sq inch
	 * @param fromUnit
	 * @param valueToConvert
	 * @param toUnit
	 * @return
	 */
	@GetMapping("/area")
	public ResponseEntity<ConversionBean> getAreaConvertedFromTo(
			@RequestParam(required = true, name = "fromUnit", defaultValue = "cm2") String fromUnit,
			@RequestParam(required = true, name = "valueToConvert") Double valueToConvert,
			@RequestParam(required = true, name = "toUnit", defaultValue = "in2") String toUnit) {
		if (valueToConvert == null) {
			throw new IllegalArgumentException("Parameter valueToConvert is Empty");
		} else {
			final ConversionBean conversionBean = areaConversionService.convertAreaFromTo(fromUnit,
					valueToConvert, toUnit);
			return ResponseEntity.ok(conversionBean);
		}
	}

}
