package com.ayo.metricconverter.exception;

import java.time.Instant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * 
 * @author Indu John
 *
 */
@RestControllerAdvice
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

	public static final String INVALID_REQUEST = "Invalid request";
	private static final String PATH = "path";
	private static final String ERRORS = "error";
	private static final String STATUS = "status";
	private static final String MESSAGE = "message";
	private static final String TIMESTAMP = "timestamp";
	private static final String TYPE = "type";
	private static final String CONVERSION_UNAVAILABLE = "Conversion Unavailable";

	/**
	 * Handle MissingServletRequestParameterException. This will be triggered when a
	 * 'required' request parameter is missing.
	 *
	 * @param ex      MissingServletRequestParameterException
	 * @param headers HttpHeaders
	 * @param status  HttpStatus
	 * @param request WebRequest
	 * @return the ErrorDetails object
	 */
	@Override
	protected ResponseEntity<Object> handleMissingServletRequestParameter(MissingServletRequestParameterException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		String error = ex.getParameterName() + " parameter is missing";
		return getExceptionResponseEntity(ex, HttpStatus.BAD_REQUEST, request, Collections.singletonList(error));
	}

	/**
	 * Handle HttpMediaTypeNotSupportedException. This one triggers when JSON is
	 * invalid as well.
	 *
	 * @param ex      HttpMediaTypeNotSupportedException
	 * @param headers HttpHeaders
	 * @param status  HttpStatus
	 * @param request WebRequest
	 * @return the ErrorDetails object
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMediaTypeNotSupported(HttpMediaTypeNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		StringBuilder builder = new StringBuilder();
		builder.append(ex.getContentType());
		builder.append(" media type is not supported. Supported media types are ");
		ex.getSupportedMediaTypes().forEach(t -> builder.append(t).append(", "));
		return getExceptionResponseEntity(ex, HttpStatus.UNSUPPORTED_MEDIA_TYPE, request,
				Collections.singletonList(ex.getLocalizedMessage()));
	}

	/**
	 * Handles HttpMessageNotReadableException. This will be triggered when JSON
	 * data has issue
	 * 
	 * @param exception HttpMessageNotReadableException
	 * @param headers   HttpHeaders
	 * @param status    HttpStatus
	 * @param request   WebRequest
	 */
	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException exception,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return getExceptionResponseEntity(exception, status, request,
				Collections.singletonList(exception.getLocalizedMessage()));
	}

	@ExceptionHandler(NoSuchConversionExistsException.class)
    public ResponseEntity<Object> handle(NoSuchConversionExistsException exception) {
        final Map<String, Object> body = new LinkedHashMap<>();
		body.put(TIMESTAMP, Instant.now());
		body.put(TYPE, exception.getClass().getSimpleName());
		body.put(MESSAGE, exception.getLocalizedMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException exception,
			HttpHeaders headers, HttpStatus status, HttpRequest request) {
		return getExceptionResponseEntity(exception, HttpStatus.BAD_REQUEST, request,
				Collections.singletonList(exception.getLocalizedMessage()));
	}

	/**
	 * Build a detailed information about the exception in the response
	 * 
	 * @param exception
	 * @param status
	 * @param request   HttpRequest
	 * @param errors
	 * @return
	 */
	private ResponseEntity<Object> getExceptionResponseEntity(final Exception exception, final HttpStatus status,
			final HttpRequest request, final List<String> errors) {
		final Map<String, Object> body = new LinkedHashMap<>();
		final String path = request.getURI().getPath();
		body.put(TIMESTAMP, Instant.now());
		body.put(STATUS, status.value());
		body.put(ERRORS, errors);
		body.put(TYPE, exception.getClass().getSimpleName());
		body.put(PATH, path);
		body.put(MESSAGE, getCustomMessageForStatus(status));
		return new ResponseEntity<>(body, status);
	}

	/**
	 * Build a detailed information about the exception in the response
	 * 
	 * @param exception
	 * @param status
	 * @param request   WebRequest
	 * @param errors
	 * @return
	 */
	private ResponseEntity<Object> getExceptionResponseEntity(final Exception exception, final HttpStatus status,
			final WebRequest request, final List<String> errors) {
		final Map<String, Object> body = new LinkedHashMap<>();
		final String path = request.getDescription(false);
		body.put(TIMESTAMP, Instant.now());
		body.put(STATUS, status.value());
		body.put(ERRORS, errors);
		body.put(TYPE, exception.getClass().getSimpleName());
		body.put(PATH, path);
		body.put(MESSAGE, getCustomMessageForStatus(status));
		return new ResponseEntity<>(body, status);
	}

	/**
	 * Can be extended to add other HTTP Statuses as well like UnAuthorized
	 * 
	 * @param status
	 * @return
	 */
	private String getCustomMessageForStatus(HttpStatus status) {
		switch (status) {
		case BAD_REQUEST:
			return INVALID_REQUEST;
		case NOT_FOUND:
			return CONVERSION_UNAVAILABLE;
		default:
			return status.getReasonPhrase();
		}
	}
}
