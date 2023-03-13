package org.math.handler;

import org.math.exception.CustomException;
import org.math.exception.CustomExceptionType;
import org.math.response.Response;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class WebExceptionHandler {

    @ExceptionHandler(CustomException.class)
    @ResponseBody
    public Response customerException(CustomException ex){
        if(ex.getCode() != CustomExceptionType.SYSTEM_ERROR.getCode()){
            // TODO 持久化
        }
        return Response.error(ex);
    }
}
