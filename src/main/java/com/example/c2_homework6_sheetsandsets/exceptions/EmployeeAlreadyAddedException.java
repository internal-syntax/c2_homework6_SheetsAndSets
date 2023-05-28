package com.example.c2_homework6_sheetsandsets.exceptions;

public class EmployeeAlreadyAddedException extends RuntimeException {
    public EmployeeAlreadyAddedException() {
        super("В коллекции уже есть такой сотрудник");
    }
}
