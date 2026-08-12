package com.example.lab7_6733804228_sec3.strategy;

public class NoDiscountStrategy implements DiscountStrategy{

    @Override
    public double calculateDiscoutedPrice(double originalPrice) {
        return originalPrice;
    }

    @Override
    public String getStrategyName() {
        return "ราคาปกติ (0%)";
    }
}
