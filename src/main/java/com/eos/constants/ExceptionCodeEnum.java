package com.eos.constants;

/**
 * The Enum ExceptionCodeEnum.
 */
public enum ExceptionCodeEnum {

	PROBLEM_CRITERIA_BIZ("PROBLEM_CRITERIA_BIZ",
			"Problems in input parameters "),

	DATA_NOT_FOUND("DATA_NOT_FOUND", "Data not found in the database "),

	USER_ACCEPTANTCE_CRITERIA("USER_ACCEPTANTCE_CRITERIA",
			"only adults ( age > 18 years)  and that live in France can create an account!");

	/** The error code. */
	private final String errorCode;

	/** The error name. */
	private final String errorContext;

	/**
	 * Instantiates a new exception code enum.
	 * 
	 * @param errorCode
	 *            the error code
	 * @param errorContext
	 *            the error context
	 */
	ExceptionCodeEnum(final String errorCode, final String errorContext) {
		this.errorCode = errorCode;
		this.errorContext = errorContext;
	}

	/**
	 * Gets the error code.
	 * 
	 * @return the error code
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * Gets the error detail.
	 * 
	 * @return the error detail
	 */
	public String getErrorContext() {
		return errorContext;
	}

}
