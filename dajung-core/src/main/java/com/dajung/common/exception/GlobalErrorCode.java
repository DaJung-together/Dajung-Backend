package com.dajung.common.exception;

public enum GlobalErrorCode implements ErrorCode {

    INTERNAL_SERVER_EXCEPTION("G001", "서버에 알 수 없는 문제가 발생했습니다."),
    NOT_FOUND_ENTITY_EXCEPTION("G002", "요청 정보에 해당하는 엔티티를 조회할 수 없습니다."),
    ;

    private final String code;
    private final String message;

    GlobalErrorCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public String code() {
        return this.code;
    }

    @Override
    public String message() {
        return this.message;
    }

}
