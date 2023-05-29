package com.ErliErli.controllers;

import com.ErliErli.entities.Customer;
import com.ErliErli.services.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/customers")


public class CustomerController {


    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }


    record newCustomerRequest(String name, String email, Integer age){}
    @PostMapping
    public void addCustomer(@RequestBody newCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerService.saveCustomer(customer);
    }

    @PutMapping("{id}")
    public void updateCustomer(@PathVariable Integer id, @RequestBody newCustomerRequest request) {
        Customer customer = new Customer();
        customer.setId(id);
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerService.putCustomer(customer);
    }

}