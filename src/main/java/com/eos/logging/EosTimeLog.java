package com.eos.logging;

public class EosTimeLog {

	private long time;
	private String method;
	private String origine;

	/**
	 * Rest log
	 * 
	 * @param origine
	 * @param time
	 * @param pathRs
	 * @param params
	 */
	public EosTimeLog(String origine, long time, String method) {
		this.time = time;
		this.method = method;
		this.origine = origine;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(origine);
		sb.append(" |");
		sb.append(method);
		sb.append(" |");
		sb.append("time processing: " + time +"ms");
		sb.append("]");
		return sb.toString();
	}
}