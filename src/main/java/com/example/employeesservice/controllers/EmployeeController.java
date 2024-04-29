package com.example.employeesservice.controllers;

import com.example.employeesservice.errorHandling.EmployeeErrorResponse;
import com.example.employeesservice.errorHandling.EmployeeInvalidDataException;
import com.example.employeesservice.errorHandling.EmployeeNotFoundException;
import com.example.employeesservice.models.Employee;
import com.example.employeesservice.dto.EmployeeDTO;
import com.example.employeesservice.services.EmployeeService;
import com.example.employeesservice.util.EmployeeValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final EmployeeValidator employeeValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public EmployeeController(EmployeeService employeeService, EmployeeValidator employeeValidator, ModelMapper modelMapper) {
        this.employeeService = employeeService;
        this.employeeValidator = employeeValidator;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll().stream().map(this::convertEmployeeToDTO).toList();
    }

    @GetMapping("/{id}")
    public EmployeeDTO getById(@PathVariable int id) {
        return employeeService.getById(id);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> notFound(EmployeeNotFoundException e) {
        return new ResponseEntity<>(new EmployeeErrorResponse(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<HttpStatus> create(@RequestBody @Valid EmployeeDTO employeeDTO, BindingResult bindingResult) throws EmployeeInvalidDataException {
        if(bindingResult.hasErrors()) {
            StringBuilder error = new StringBuilder();
            bindingResult.getAllErrors().forEach(e -> error.append(e.getDefaultMessage()).append("; "));

            throw new EmployeeInvalidDataException(error.toString());
        }
        employeeService.save(convertDTOToEmployee(employeeDTO));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> invalidData(EmployeeInvalidDataException e) {
        return new ResponseEntity<>(new EmployeeErrorResponse(e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    private EmployeeDTO convertEmployeeToDTO(Employee employee) {
        return modelMapper.map(employee, EmployeeDTO.class);
    }
    private Employee convertDTOToEmployee(EmployeeDTO employeeDTO) {
        return modelMapper.map(employeeDTO, Employee.class);
    }
}
