package com.spring.app.trainSheet.exceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.LocalDate.now;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

@RestControllerAdvice
public class ControllerHandlerException extends ResponseEntityExceptionHandler {

    @ExceptionHandler(TrainSheetException.class)
    public ResponseEntity<?> trainSheetException(TrainSheetException sheetException) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("error", sheetException.getMessage());
        body.put("timespan", now());
        return new ResponseEntity<>(body, BAD_REQUEST);
    }

}
