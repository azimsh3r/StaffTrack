package com.example.employeesservice.errorHandling;

import java.time.LocalDateTime;

public class EmployeeErrorResponse {
    public String message;
    public LocalDateTime timeStamp;

    public EmployeeErrorResponse(String message) {
        this.message = message;
        this.timeStamp = LocalDateTime.now();
    }
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
