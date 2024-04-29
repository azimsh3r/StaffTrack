package com.example.employeesservice.services;

import com.example.employeesservice.dto.AddressResponse;
import com.example.employeesservice.dto.EmployeeDTO;
import com.example.employeesservice.errorHandling.EmployeeNotFoundException;
import com.example.employeesservice.models.Employee;
import com.example.employeesservice.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class EmployeeService {

    @Value("${addressservice.base.url}")
    private String baseUrl;

    private final ModelMapper modelMapper;
    private final WebClient webClient;
    private final EmployeeRepository employeeRepository;

//    private DiscoveryClient discoveryClient;

    private final LoadBalancerClient loadBalancerClient;

    @Autowired
    public EmployeeService(ModelMapper modelMapper, WebClient webClient, EmployeeRepository employeeRepository, DiscoveryClient discoveryClient, LoadBalancerClient loadBalancerClient) {
        this.modelMapper = modelMapper;
        this.webClient = webClient;
        this.employeeRepository = employeeRepository;
//        this.discoveryClient = discoveryClient;
        this.loadBalancerClient = loadBalancerClient;
    }

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public EmployeeDTO getById(int id) {
        Employee employee = employeeRepository.findById(id).stream().findAny().orElseThrow(() ->new EmployeeNotFoundException("Employee with the id is not Found"));
        EmployeeDTO employeeDTO = modelMapper.map(employee, EmployeeDTO.class);

        AddressResponse addressResponse = getAddressById(id);

//        AddressResponse addressResponse = addressClient.getByEmpId(id);

        employeeDTO.setAddressResponse(addressResponse);
        return employeeDTO;
    }

    public AddressResponse getAddressById(int id) {

        ServiceInstance serviceInstance  = loadBalancerClient.choose("address-service");

//        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("address-service");

        String url = String.valueOf(serviceInstance.getUri());
        String contextPath = serviceInstance.getMetadata().get("configPath");

        return webClient
                .get().uri(url+contextPath+"/address/{id}", id)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(AddressResponse.class)
                .block();
    }

    public void save(Employee employee) {
        employeeRepository.save(employee);
    }
}
