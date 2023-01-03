package com.example.pointsystem.services;

import com.example.pointsystem.models.entities.Customer;
import com.example.pointsystem.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer getById(long customerId) {
        return customerRepository.getReferenceById(customerId);
    }
}
