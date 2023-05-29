package com.ErliErli.controllers;

import com.ErliErli.entities.Employee;
import com.ErliErli.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    record newEmployeeRequest(String name, String email, Integer age){}
    @PostMapping
    public void addEmployee(@RequestBody EmployeeController.newEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.name());
        employee.setEmail(request.email());
        employee.setAge(request.age());
        employeeService.saveEmployee(employee);
    }


    @PutMapping
    public void updateEmployee(@PathVariable Integer id, @RequestBody EmployeeController.newEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(request.name());
        employee.setEmail(request.email());
        employee.setAge(request.age());
        employeeService.putEmployee(employee);
    }


}