package com.example.demo.service;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public void insertCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer getCustomer(Long phoneNo){
        Customer customer=customerRepository.findById(phoneNo).get();
        return customer;
    }
}
