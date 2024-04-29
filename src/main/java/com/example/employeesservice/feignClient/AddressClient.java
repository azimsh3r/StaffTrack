package com.example.employeesservice.feignClient;

import com.example.employeesservice.dto.AddressResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="address")
public interface AddressClient {
    @GetMapping("/address/{id}")
    public AddressResponse getByEmpId(@PathVariable("id") int id);
}
