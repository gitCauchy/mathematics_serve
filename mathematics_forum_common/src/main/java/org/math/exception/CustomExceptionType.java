package org.math.exception;

public enum CustomExceptionType {
    USER_INPUT_ERROR(400, "用户输入异常"),
    SYSTEM_ERROR(500, "系统服务异常"),
    OTHER_ERROR(999, "未知异常");

    CustomExceptionType(int code, String typeDesc) {
        this.code = code;
        this.typeDesc = typeDesc;
    }

    /**
     * 异常代码
     */
    private final int code;
    /**
     * 异常说明
     */
    private final String typeDesc;

    public int getCode() {
        return code;
    }

    public String getTypeDesc() {
        return typeDesc;
    }
}
