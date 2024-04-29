package com.example.employeesservice.errorHandling;


import org.springframework.data.crossstore.ChangeSetPersister;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String e) {
        super(e);
    }
}
