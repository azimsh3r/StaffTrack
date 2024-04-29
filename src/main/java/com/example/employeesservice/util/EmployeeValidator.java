package com.example.employeesservice.util;

import com.example.employeesservice.models.Employee;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class EmployeeValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.equals(Employee.class);
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}
