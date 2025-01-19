package com.example.nob2v2.exceptions;


import com.example.nob2v2.product.model.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse handleProductNotFoundException(ProductNotFoundException exception){
        return new ErrorResponse(exception.getMessage());
    }
    @ExceptionHandler(ProductNotValidException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleProductNotValidException(ProductNotValidException exception){
        return new ErrorResponse(exception.getMessage());

    }



    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleConstraintViolationException(ConstraintViolationException exception) {
        String message = exception.getConstraintViolations().iterator().next().getMessage();
        System.out.println(message + "ALOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
        return new ErrorResponse(message);
    }


    @ExceptionHandler(InvalidItemException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleDescriptionContainsProfanityException( InvalidItemException exception){
            return new ErrorResponse(exception.getMessage());

    }



}
