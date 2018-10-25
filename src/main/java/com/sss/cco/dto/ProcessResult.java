package com.sss.cco.dto;

public class ProcessResult {
	private String output;
	private Integer returnValue;

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public Integer getReturnValue() {
		return returnValue;
	}

	public void setReturnValue(Integer returnValue) {
		this.returnValue = returnValue;
	}

	public ProcessResult(String output, Integer returnValue) {
		this.output = output;
		this.returnValue = returnValue;
	}
}
