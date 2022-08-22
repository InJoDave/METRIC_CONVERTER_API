package com.ayo.metricconverter.controller;

import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import com.ayo.metricconverter.MetricconverterApplication;

/**
 * 
 * @author Indu John
 *
 */
//INTEGRATION TEST
@SpringBootTest(classes = MetricconverterApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ConversionControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetLengthConvertedFromTo() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/convert/length?fromUnit=cm&toUnit=in&valueToConvert=1"), HttpMethod.GET, entity,
				String.class);
		String expected = "{\"conversionType\":\"Length\",\"from\":\"cm\",\"value\":1,\"to\":\"in\",\"result\":0.39}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testGetTemperatureConvertedFromTo() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/convert/temperature?fromUnit=c&toUnit=f&valueToConvert=12.34"), HttpMethod.GET, entity,
				String.class);
		String expected = "{\"conversionType\":\"Temperature\",\"from\":\"c\",\"value\":12.34,\"to\":\"f\",\"result\":54.21}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testGetWeightConvertedFromTo() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/convert/weight?fromUnit=g&toUnit=oz&valueToConvert=1"), HttpMethod.GET, entity,
				String.class);
		String expected = "{\"conversionType\":\"Weight\",\"from\":\"g\",\"value\":1,\"to\":\"oz\",\"result\":0.04}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
	
	@Test
	public void testGetAreaConvertedFromTo() throws JSONException {
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/convert/area?fromUnit=acre&toUnit=m2&valueToConvert=1"), HttpMethod.GET, entity,
				String.class);
		String expected = "{\"conversionType\":\"Area\",\"from\":\"acre\",\"value\":1,\"to\":\"m2\",\"result\":4046.9}";
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
