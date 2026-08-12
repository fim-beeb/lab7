package com.example.lab7_6733804228_sec3.strategy;

public class SeasonalSaleStrategy implements DiscountStrategy{
    @Override
    public double calculateDiscoutedPrice(double originalPrice) {
        return originalPrice * 0.8;
    }

    @Override
    public String getStrategyName() {
        return "ส่วนลดเทศกาล (20%)";
    }
}
