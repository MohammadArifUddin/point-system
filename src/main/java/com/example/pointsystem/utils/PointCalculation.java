package com.example.pointsystem.utils;

import com.example.pointsystem.models.constants.PaymentMethod;
import org.springframework.stereotype.Component;

import static com.example.pointsystem.models.constants.PaymentMethod.*;

@Component
public class PointCalculation {

    public long getFinalPoints(PaymentMethod paymentMethod, float price){
        if(paymentMethod.equals(CASH)){
            return (int) (price*0.05);
        } else if (paymentMethod.equals(CASH_ON_DELIVERY)) {
            return (int) (price*0.05);
        } else if (paymentMethod.equals(VISA)) {
            return (int) (price*0.03);
        } else if (paymentMethod.equals(MASTERCARD)) {
            return (int) (price*0.03);
        } else if (paymentMethod.equals(AMEX)) {
            return (int) (price*0.02);
        } else if (paymentMethod.equals(JCB)) {
            return (int) (price*0.05);
        } else if (paymentMethod.equals(LINE_PAY)) {
            return (int) (price*0.01);
        } else if (paymentMethod.equals(PAYPAY)) {
            return (int) (price*0.01);
        } else if (paymentMethod.equals(POINTS)) {
            return 0;
        } else if (paymentMethod.equals(GRAB_PAY)) {
            return (int) (price*0.01);
        } else if (paymentMethod.equals(BANK_TRANSFER)) {
            return 0;
        }else{
            return 0;
        }
    }
}
