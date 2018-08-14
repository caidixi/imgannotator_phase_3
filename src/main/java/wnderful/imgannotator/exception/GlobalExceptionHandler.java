package wnderful.imgannotator.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import wnderful.imgannotator.publicData.reponseCode.GlobalRepCode;
import wnderful.imgannotator.publicData.response.GlobalResponse;
import wnderful.imgannotator.publicData.response.Response;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

@ControllerAdvice
@RestController
public class GlobalExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Response allExceptionHandler(Exception exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.SERVERFAIL);
    }

    @ExceptionHandler(value = IOException.class)
    @ResponseBody
    public Response usernameExceptionHandler(IOException exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.WRITEERROE);
    }

    @ExceptionHandler(value = UnsupportedEncodingException.class)
    @ResponseBody
    public Response tokenExceptionHandler(UnsupportedEncodingException exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.TOKENERROR);
    }

    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public Response dataIntegrityViolationExceptionHandler(DataIntegrityViolationException exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.DATAERROE);
    }

    @ExceptionHandler(value = RechargeException.class)
    @ResponseBody
    public Response RechargeExceptionHandler(RechargeException exception) {
        exception.printStackTrace();
        return new GlobalResponse(GlobalRepCode.WrongCode);
    }

}
