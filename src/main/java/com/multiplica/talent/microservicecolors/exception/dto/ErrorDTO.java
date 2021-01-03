package com.multiplica.talent.microservicecolors.exception.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;


@Data
public class ErrorDTO {

    private int statusCode;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", shape = JsonFormat.Shape.STRING)
    private Date timestamp;
    private String message;
}
