package com.example.lab7_6733804228_sec3.strategy;

public class StudentDiscountStrategy implements DiscountStrategy{
    @Override
    public double calculateDiscoutedPrice(double originalPrice) {
        return originalPrice * 0.9;
    }

    @Override
    public String getStrategyName() {
        return "ส่วนลดนักศึกษา (10%)";
    }
}
