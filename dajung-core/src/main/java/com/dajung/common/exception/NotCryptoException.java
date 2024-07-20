package com.dajung.common.exception;

public class NotCryptoException extends BusinessException {

	public NotCryptoException(ErrorCode errorCode) {
		super(errorCode);
	}

	public NotCryptoException(ErrorCode errorCode, String loggingMessage) {
		super(errorCode, loggingMessage);
	}

}
