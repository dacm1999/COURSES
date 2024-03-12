package com.dacm.restfullservices.rest;

import com.dacm.restfullservices.entity.StudentErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

    //Add exception hadling code here
    /**
     * Add an exception handler using @ExceptionHandler
     * @param exc
     * @return
     */
    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (StudentNotFoundException exc){
        //Create a StudentErrorResponse
        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        //Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<StudentErrorResponse> handleException (Exception exc){

        StudentErrorResponse error = new StudentErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("Introduce un valor correcto");
        error.setTimeStamp(System.currentTimeMillis());
        //Return ResponseEntity
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

    }
}
