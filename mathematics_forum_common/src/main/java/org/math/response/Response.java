package org.math.response;

import lombok.Data;
import org.math.exception.CustomException;
import org.math.exception.CustomExceptionType;

@Data
public class Response {
    /**
     * 是否成功
     */
    private boolean success;
    /**
     * 返回码
     */
    private int code;
    /**
     * 返回信息
     */
    private String message;
    /**
     * 返回数据对象
     */
    private Object data;

    private Response() {
    }

    /**
     * @param ex
     * @return
     */
    public static Response error(CustomException ex) {
        Response result = new Response();
        result.setSuccess(false);
        result.setCode(ex.getCode());
        if (ex.getCode() == CustomExceptionType.USER_INPUT_ERROR.getCode()) {
            result.setMessage(CustomExceptionType.USER_INPUT_ERROR.getTypeDesc());
        } else if (ex.getCode() == CustomExceptionType.SYSTEM_ERROR.getCode()) {
            result.setMessage(CustomExceptionType.SYSTEM_ERROR.getTypeDesc());
        } else {
            result.setMessage(CustomExceptionType.OTHER_ERROR.getTypeDesc());
        }
        // TODO 异常信息持久化
        return result;
    }

    /**
     * @param ex
     * @param exType
     * @param errMessage
     * @return
     */
    public static Response error(CustomException ex, CustomExceptionType exType, String errMessage) {
        Response result = new Response();
        result.setSuccess(false);
        result.setCode(exType.getCode());
        result.setMessage(errMessage);
        return result;
    }

    public static Response success() {
        Response result = new Response();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("success");
        return result;
    }

    public static Response success(Object data) {
        Response result = new Response();
        result.setSuccess(true);
        result.setCode(200);
        result.setMessage("success");
        result.setData(data);
        return result;
    }
}
