package com.eos.logging;

public class EosLog extends LogClass {
	private String pathRs;
	private String method;

	/**
	 * Rest log
	 * 
	 * @param origine
	 * @param description
	 * @param pathRs
	 * @param params
	 */
	public EosLog(String origine, String description, String method,
			String pathRs, Object params) {
		super(origine, description, params);
		this.pathRs = pathRs;
		this.method = method;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(getOrigine());
		sb.append(" |");
		sb.append(getDescription());
		sb.append(" |");
		sb.append(method);
		sb.append(" |");
		sb.append(pathRs);
		sb.append(" |");
		sb.append(getParams());
		sb.append("]");
		return sb.toString();
	}
}