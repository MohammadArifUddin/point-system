package com.example.pointsystem.controllers;

import com.example.pointsystem.payload.request.CreatePaymentRequest;
import com.example.pointsystem.payload.request.GetSalesRequest;
import com.example.pointsystem.payload.response.CreatePaymentResponse;
import com.example.pointsystem.payload.response.GetSalesProjection;
import com.example.pointsystem.services.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping("/sales")
    public ResponseEntity<List<GetSalesProjection>> getSalesData(@RequestBody GetSalesRequest getSalesRequest) {

        return ResponseEntity.ok(paymentService.getSales(getSalesRequest));
    }

    @PostMapping
    public ResponseEntity<?> createPayment(@RequestBody CreatePaymentRequest createPaymentRequest){

        CreatePaymentResponse createPaymentResponse = paymentService.save(createPaymentRequest);

        return ResponseEntity.ok(createPaymentResponse);
    }





}
