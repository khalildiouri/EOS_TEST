package com.eos.logging;

import com.eos.constants.Constants;

public final class FactoryLog {

	/**
	 * Private constructor
	 */
	private FactoryLog() {
		super();
	}

	/**
	 * Rest logging
	 * 
	 * @param origine
	 * @param description
	 * @param pathRs
	 * @param params
	 * @return
	 */
	public static String getEosLog(String origine, String description,
			String method, String pathRs, Object params) {
		if (params == null) {
			params = Constants.NO_PARAM;
		}
		return new EosLog(origine, description, method, pathRs, params)
				.toString();
	}

	public static String getProcessingTimeLog(long time, String method,
			String origine) {

		return new EosTimeLog(origine, time, method).toString();
	}

}