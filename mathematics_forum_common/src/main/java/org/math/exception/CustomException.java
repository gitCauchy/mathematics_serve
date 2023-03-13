package org.math.exception;

public class CustomException extends RuntimeException {
    /**
     * 异常错误编码
     */
    private int code;
    /**
     * 异常信息
     */
    private String message;

    private CustomException() {
    }

    public CustomException(CustomExceptionType exceptionType, String message) {
        this.code = exceptionType.getCode();
        this.message = exceptionType.getTypeDesc();
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
