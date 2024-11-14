package com.sp.main.exception;

import com.sp.main.payload.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import javax.xml.crypto.Data;
import java.sql.Date;
import java.text.DateFormat;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobleHandleException {

   @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<ErrorDetails> handleResourceNotFound(ResourceNotFound e , WebRequest request){
       ErrorDetails error = new ErrorDetails( e.getMessage() ,request.getDescription(false) );
       return new ResponseEntity<ErrorDetails>(error , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String ,String>  handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
       Map<String, String> errorMap = new HashMap<>();
       e.getBindingResult().getFieldErrors().forEach(error ->

              errorMap.put(error.getField() , error.getDefaultMessage())
               );
       return errorMap;

    }

}
