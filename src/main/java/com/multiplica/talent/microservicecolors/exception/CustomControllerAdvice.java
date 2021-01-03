package com.multiplica.talent.microservicecolors.exception;


import com.multiplica.talent.microservicecolors.exception.dto.ErrorDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;


@Slf4j
@ControllerAdvice
public class CustomControllerAdvice  {


    @ExceptionHandler
    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ResponseBody
    ErrorDTO badMediType(HttpMediaTypeNotSupportedException ex) {
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setStatusCode(HttpStatus.UNSUPPORTED_MEDIA_TYPE.value());
        errorDto.setTimestamp(new Date());
        errorDto.setMessage(ex.getMessage());
        log.error(ex.getMessage());
        return errorDto;
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorDTO badRequest(HttpMessageNotReadableException  e ){
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDto.setTimestamp(new Date());
        errorDto.setMessage("El request body es inválido");
        return errorDto;
    }



    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    ErrorDTO internalServer(Throwable e ){
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDto.setTimestamp(new Date());
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    ErrorDTO dataIntegrity(DataIntegrityViolationException e ){
        ErrorDTO errorDto = new ErrorDTO();
        errorDto.setStatusCode(HttpStatus.BAD_REQUEST.value());
        errorDto.setTimestamp(new Date());
        errorDto.setMessage(e.getMessage());
        return errorDto;
    }
}
