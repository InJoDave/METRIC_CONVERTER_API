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
				createURLWithPort("/convert/length?fromUnit=cm&toUnit=mm&valueToConvert=1.234"), HttpMethod.GET, entity,
				String.class);
		String expected = "{\"conversionType\":\"Length\",\"from\":\"cm\",\"value\":1.234,\"to\":\"mm\",\"result\":12.34}";
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

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}

}
