package com.example.c2_homework6_sheetsandsets.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class EmployeeIncorrectDataException extends RuntimeException {
    public EmployeeIncorrectDataException () {
        super("Данные введены не корректно");
    }

}
