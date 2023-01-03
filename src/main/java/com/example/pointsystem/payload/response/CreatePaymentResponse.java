package com.example.pointsystem.payload.response;

public class CreatePaymentResponse {

    private float finalPrice;

    private long points;

    public CreatePaymentResponse() {

    }

    public CreatePaymentResponse(float finalPrice, long points) {
        this.finalPrice = finalPrice;
        this.points = points;
    }

    public float getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(float finalPrice) {
        this.finalPrice = finalPrice;
    }

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
