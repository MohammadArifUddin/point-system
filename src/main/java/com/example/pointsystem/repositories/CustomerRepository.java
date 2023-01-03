package com.example.pointsystem.repositories;

import com.example.pointsystem.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
