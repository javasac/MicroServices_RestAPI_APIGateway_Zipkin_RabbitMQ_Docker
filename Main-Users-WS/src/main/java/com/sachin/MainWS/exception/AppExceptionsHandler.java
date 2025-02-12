package com.sachin.MainWS.exception;
import com.sachin.MainWS.response.ErrorMessage;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import java.util.Date;

@RestControllerAdvice
public class AppExceptionsHandler extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(value = {NullPointerException.class, UserServiceException.class})
    public ResponseEntity<Object> handleManyExceptions(NullPointerException e, WebRequest req)
    {
        System.out.println("in handleManyExceptions");
        String errMsg = e.getLocalizedMessage();

        if (errMsg == null)
        {
            errMsg = e.toString();
        }

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errMsg);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity<Object> handleAnyException(Exception e, WebRequest req)
    {
        System.out.println("in handleAnyException");
        String errMsg = e.getLocalizedMessage();

        if (errMsg == null)
        {
            errMsg = e.toString();
        }

        ErrorMessage errorMessage = new ErrorMessage(new Date(), errMsg);
        return new ResponseEntity<>(errorMessage, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
