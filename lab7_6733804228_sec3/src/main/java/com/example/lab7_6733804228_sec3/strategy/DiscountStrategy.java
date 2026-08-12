package com.example.lab7_6733804228_sec3.strategy;

public interface DiscountStrategy {
    double calculateDiscoutedPrice(double originalPrice);
    String getStrategyName();
}
