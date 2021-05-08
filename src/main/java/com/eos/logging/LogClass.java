package com.eos.logging;

public class LogClass {
	protected String origine;
	protected String description;
	protected Object params;

	/**
	 * Constructor with fields
	 * 
	 * @param origine
	 * @param description
	 * @param params
	 */
	public LogClass(String origine, String description, Object params) {
		super();
		this.origine = origine;
		this.description = description;
		this.params = params;
	}

	/**
	 * default constructor
	 */
	public LogClass() {
	}

	/**
	 * @return the origine
	 */
	public String getOrigine() {
		return origine;
	}

	/**
	 * @param origine
	 *            the origine to set
	 */
	public void setOrigine(String origine) {
		this.origine = origine;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the params
	 */
	public Object getParams() {
		Object vObj = "Null Object";
		if (params != null) {
			vObj = params.toString();
		}
		return vObj;
	}

	/**
	 * @param params
	 *            the params to set
	 */
	public void setParams(Object params) {
		this.params = params;
	}
}