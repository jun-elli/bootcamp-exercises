package com.bootcamp.airlane.airlane.controller;

import com.bootcamp.airlane.airlane.model.Customer;
import com.bootcamp.airlane.airlane.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping("/list")
    public List<Customer> listCustomers() {
        return customerService.listCustomers();
    }
}
