package com.example.pointsystem.payload.request;

import com.example.pointsystem.models.constants.PaymentMethod;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class CreatePaymentRequest {

    @NotBlank
    private Long customerId;

    @NotBlank
    private float price;

    @NotBlank
    private float priceModifier;

    @NotBlank
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NotBlank
    private Date datetime;

    private AdditionalItem additionalItem;

    public CreatePaymentRequest(Long customerId, float price, float priceModifier, PaymentMethod paymentMethod, Date datetime, AdditionalItem additionalItem) {
        this.customerId = customerId;
        this.price = price;
        this.priceModifier = priceModifier;
        this.paymentMethod = paymentMethod;
        this.datetime = datetime;
        this.additionalItem = additionalItem;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPriceModifier() {
        return priceModifier;
    }

    public void setPriceModifier(float priceModifier) {
        this.priceModifier = priceModifier;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public AdditionalItem getAdditionalItem() {
        return additionalItem;
    }

    public void setAdditionalItem(AdditionalItem additionalItem) {
        this.additionalItem = additionalItem;
    }

    public static class AdditionalItem{

        String last4;

        String courier;

        public AdditionalItem(String last4, String courier) {
            this.last4 = last4;
            this.courier = courier;
        }

        public String getLast4() {
            return last4;
        }

        public void setLast4(String last4) {
            this.last4 = last4;
        }

        public String getCourier() {
            return courier;
        }

        public void setCourier(String courier) {
            this.courier = courier;
        }
    }

}
