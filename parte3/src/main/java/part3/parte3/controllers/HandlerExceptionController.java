package part3.parte3.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;
import part3.parte3.models.Error;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class HandlerExceptionController {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<Error > divisionByZero(Exception ex){
        Error error=new Error();
        error.setDate(new Date());
        error.setError("Error division por cero!");
        error.setMessage(ex.getMessage());
        error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        //return ResponseEntity.internalServerError().body(error);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR.value()).body(error);

    }

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Error> notFoundex(NoHandlerFoundException ex){
        Error error=new Error();
        error.setDate(new Date());
        error.setMessage(ex.getMessage());
        error.setError("Api rest no encontrado");
        error.setStatus(HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND.value()).body(error);
    }

    @ExceptionHandler(NumberFormatException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map <String,Object> numberFormatException(Exception ex){
        Map<String,Object> error= new HashMap<>();
        error.put("date",new Date());
        error.put("error","Numero invalido es incorrecto");
        error.put("message",ex.getMessage());
        error.put("status",HttpStatus.INTERNAL_SERVER_ERROR.value());
        return error;
    }
}
