package com.example.pointsystem.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "customer_payments",
            joinColumns = @JoinColumn(name = "payment_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers = new HashSet<>();

    private float paidAmount;

    private Long pointAmount;

    private String paymentMethod;

    private String last4;

    private String courier;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @CreationTimestamp
    private LocalDateTime updatedAt;

    public Payment() {
    }

    public Payment(Set<Customer> customers, float paidAmount, Long pointAmount, String paymentMethod, String last4, String courier) {
        this.customers = customers;
        this.paidAmount = paidAmount;
        this.pointAmount = pointAmount;
        this.paymentMethod = paymentMethod;
        this.last4 = last4;
        this.courier = courier;
    }
}
