package com.ayo.metricconverter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ayo.metricconverter.entity.ConversionBean;
import com.ayo.metricconverter.service.LengthConversionService;
import com.ayo.metricconverter.service.TemperatureConversionService;

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
			@RequestParam(required = true, name = "toUnit", defaultValue = "mm") String toUnit) {
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
			final ConversionBean conversionBean = temperatureConversionService.convertTemperatureFromTo(fromUnit, valueToConvert,
					toUnit);
			return ResponseEntity.ok(conversionBean);
		}
	}

}
