package com.wjrong.exception;

@SuppressWarnings("serial")
public class DException extends RuntimeException {

	public DException() {
	}

	public DException(String message, Throwable cause) {
		super(message, cause);
	}

	public DException(String message) {
		super(message);
	}

	public DException(Throwable cause) {
		super(cause);
	}

}
