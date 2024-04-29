package com.example.employeesservice.errorHandling;

public class EmployeeInvalidDataException extends Exception{
    public EmployeeInvalidDataException(String e) {
        super(e);
    }
}
