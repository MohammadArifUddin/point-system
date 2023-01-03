package com.example.pointsystem.services;

import com.example.pointsystem.models.entities.Customer;
import com.example.pointsystem.models.entities.Payment;
import com.example.pointsystem.payload.request.CreatePaymentRequest;
import com.example.pointsystem.payload.request.GetSalesRequest;
import com.example.pointsystem.payload.response.CreatePaymentResponse;
import com.example.pointsystem.payload.response.GetSalesProjection;
import com.example.pointsystem.repositories.PaymentRepository;
import com.example.pointsystem.utils.PaymentValidation;
import com.example.pointsystem.utils.PointCalculation;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PaymentServiceImpl implements PaymentService {

    private final CustomerService customerService;
    private final PaymentRepository paymentRepository;
    private final PaymentValidation paymentValidation;
    private final PointCalculation pointCalculation;

    public PaymentServiceImpl(
            CustomerService customerService,
            PaymentRepository paymentRepository,
            PaymentValidation paymentValidation,
            PointCalculation pointCalculation
    ) {
        this.customerService = customerService;
        this.paymentRepository = paymentRepository;
        this.paymentValidation = paymentValidation;
        this.pointCalculation = pointCalculation;
    }

    @Override
    public List<GetSalesProjection> getSales(GetSalesRequest getSalesRequest) {
        return  paymentRepository.findByDate(getSalesRequest.getStartDateTime(),getSalesRequest.getEndDateTime());
    }

    @Override
    public CreatePaymentResponse save(CreatePaymentRequest request) {

        CreatePaymentResponse createPaymentResponse= new CreatePaymentResponse();

        if (paymentValidation.check(request.getPaymentMethod(), request.getPriceModifier())) {
            Customer customer = customerService.getById(request.getCustomerId());
            Set<Customer> customers = new HashSet<>();
            customers.add(customer);

            float finalPrice = (float) (request.getPrice() * request.getPriceModifier());
            long finalPoint = pointCalculation.getFinalPoints(request.getPaymentMethod(), request.getPrice());

            Payment payment = new Payment(
                    customers,
                    finalPrice,
                    finalPoint,
                    request.getPaymentMethod().toString(),
                    request.getAdditionalItem().getLast4(),
                    request.getAdditionalItem().getCourier()
            );
            paymentRepository.save(payment);
            createPaymentResponse.setFinalPrice(finalPrice);
            createPaymentResponse.setPoints(finalPoint);
        }

        return createPaymentResponse;
    }
}
