package com.dajung.common.exception;

public class ExistsException extends BusinessException {

	public ExistsException(ErrorCode errorCode) {
		super(errorCode);
	}

	public ExistsException(ErrorCode errorCode, String loggingMessage) {
		super(errorCode, loggingMessage);
	}

}
