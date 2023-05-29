package com.ErliErli.services;

import com.ErliErli.entities.Customer;
import com.ErliErli.entities.Employee;
import com.ErliErli.repos.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee putEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

}