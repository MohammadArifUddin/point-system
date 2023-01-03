package com.example.pointsystem.utils;

import com.example.pointsystem.models.constants.PaymentMethod;
import org.springframework.stereotype.Component;

import static com.example.pointsystem.models.constants.PaymentMethod.*;

@Component
public class PaymentValidation {

    public boolean check(PaymentMethod paymentMethod, float priceModifier){

        if(paymentMethod.equals(CASH) && !(0.9f<=priceModifier && priceModifier<=1)){
            return false;
        } else if (paymentMethod.equals(CASH_ON_DELIVERY) && !(0.9f<=priceModifier && priceModifier<=1)) {
            return false;
        } else if (paymentMethod.equals(VISA) && !(1<=priceModifier && priceModifier<=1.02f)) {
            return false;
        } else if (paymentMethod.equals(MASTERCARD) && !(0.95f<=priceModifier && priceModifier<=1)) {
            return false;
        } else if (paymentMethod.equals(AMEX) && !(0.98f<=priceModifier && priceModifier<=1)) {
            return false;
        } else if (paymentMethod.equals(JCB) && !(0.95f<=priceModifier && priceModifier<=1)) {
            return false;
        } else if (paymentMethod.equals(LINE_PAY) && priceModifier!=1) {
            return false;
        } else if (paymentMethod.equals(PAYPAY) && priceModifier!=1) {
            return false;
        } else if (paymentMethod.equals(POINTS) && priceModifier!=1) {
            return false;
        } else if (paymentMethod.equals(GRAB_PAY) && priceModifier!=1) {
            return false;
        } else if (paymentMethod.equals(BANK_TRANSFER) && priceModifier!=1) {
            return false;
        }else{
            return true;
        }
    }

}
