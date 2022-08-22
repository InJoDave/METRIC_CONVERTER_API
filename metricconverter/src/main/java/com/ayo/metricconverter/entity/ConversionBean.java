package com.ayo.metricconverter.entity;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 
 * @author Indu John
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversionBean {

	private String conversionType;

	@JsonProperty(required = true)
	@NotEmpty
	@NotBlank
	private String from;

	@JsonProperty(required = true)
	@NotEmpty
	private BigDecimal value;

	@JsonProperty(required = true)
	@NotEmpty
	@NotBlank
	private String to;

	private BigDecimal result;
}
