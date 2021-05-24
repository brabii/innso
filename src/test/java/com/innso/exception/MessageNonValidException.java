package com.innso.exception;

public class MessageNonValidException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MessageNonValidException() {
		super();
	}

	public MessageNonValidException(String message) {
		super(message);
	}

	public MessageNonValidException(String message, Throwable throwable) {
		super(message, throwable);
	}

	public MessageNonValidException(Throwable throwable) {
		super(throwable);
	}
}
