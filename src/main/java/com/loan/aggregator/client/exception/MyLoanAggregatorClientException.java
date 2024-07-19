package com.loan.aggregator.client.exception;

import org.springframework.validation.Errors;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MyLoanAggregatorClientException extends RuntimeException {

	private String statusCode;
	private Errors errors;

	public MyLoanAggregatorClientException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private MyLoanAggregatorClientException(String message, Errors errors) {
		super(message);
		this.errors = errors;
	}

	public MyLoanAggregatorClientException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MyLoanAggregatorClientException(String message) {
		super(message);
	}

	public MyLoanAggregatorClientException() {
		super();
	}

	public MyLoanAggregatorClientException(String statusCode,String message) {
		super(message);
		this.statusCode = statusCode;
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public MyLoanAggregatorClientException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the statusCode
	 */
	public String getStatusCode() {
		return statusCode;
	}

	/**
	 * @param statusCode the statusCode to set
	 */
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * @return the errors
	 */
	public Errors getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Errors errors) {
		this.errors = errors;
	}

}
