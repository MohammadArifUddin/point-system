package com.example.pointsystem.services;

import com.example.pointsystem.models.entities.Payment;
import com.example.pointsystem.payload.request.CreatePaymentRequest;
import com.example.pointsystem.payload.request.GetSalesRequest;
import com.example.pointsystem.payload.response.CreatePaymentResponse;
import com.example.pointsystem.payload.response.GetSalesProjection;

import java.util.List;

public interface PaymentService {

    List<GetSalesProjection> getSales(GetSalesRequest getSalesRequest);
    CreatePaymentResponse save(CreatePaymentRequest createPaymentRequest);
}
