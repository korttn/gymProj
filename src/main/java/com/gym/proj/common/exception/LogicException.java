package com.gym.proj.common.exception;

public class LogicException extends Exception {

	private static final long serialVersionUID = -4124980788043425818L;
	
	private String	code;
	private String	msg;

	public LogicException(String code) {
		this.code 	= code;
	}

	public LogicException(String code, String msg) {
		this.code	= code;
		this.msg	= msg;
	}

	@Override
	public String getMessage() {
		return this.msg;
	}

	public String getCode() {
		return this.code;
	}
}
