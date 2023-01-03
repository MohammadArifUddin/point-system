package com.example.pointsystem.services;

import com.example.pointsystem.models.entities.Customer;

public interface CustomerService {
    Customer getById(long customerId);
}
