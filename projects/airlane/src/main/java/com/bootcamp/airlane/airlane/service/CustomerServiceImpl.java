package com.bootcamp.airlane.airlane.service;

import com.bootcamp.airlane.airlane.model.Customer;
import com.bootcamp.airlane.airlane.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public List<Customer> listCustomers() {
        return customerRepository.findAll();
    }
}
