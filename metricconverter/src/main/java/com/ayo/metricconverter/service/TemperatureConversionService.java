package com.ayo.metricconverter.service;

import com.ayo.metricconverter.entity.ConversionBean;

/**
 * 
 * @author Indu John
 *
 */
public interface TemperatureConversionService {

	public ConversionBean convertTemperatureFromTo(final String from, final double fromValue, final String to);
}
