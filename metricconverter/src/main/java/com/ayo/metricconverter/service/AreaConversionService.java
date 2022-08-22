package com.ayo.metricconverter.service;

import com.ayo.metricconverter.entity.ConversionBean;

/**
 * 
 * @author Indu John
 *
 */
public interface AreaConversionService {

	public ConversionBean convertAreaFromTo(final String from, final double fromValue, final String to);

}