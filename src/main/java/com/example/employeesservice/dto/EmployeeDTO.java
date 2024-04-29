package com.example.employeesservice.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import java.util.Map;

public class EmployeeDTO {
    private int id;

    @NotNull(message = "Name cannot be empty")
    private String name;

    @NotNull(message = "BloodGroup cannot be empty")
    private String bloodGroup;

    @Email(message = "Email invalid")
    @NotNull(message = "Email cannot be null")
    private String email;

    private AddressResponse addressResponse;

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
