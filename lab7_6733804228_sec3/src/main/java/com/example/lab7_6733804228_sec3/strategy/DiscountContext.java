package com.example.lab7_6733804228_sec3.strategy;

public class DiscountContext {
    private DiscountStrategy discountStrategy;

    public DiscountContext(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }

    public double executeStrategy(double price){
        if (discountStrategy == null){
            return price;
        }
        return discountStrategy.calculateDiscoutedPrice(price);
    }

    public DiscountContext() {
    }

    public String getStrategyName(){
        if (discountStrategy == null){
            return "ราคาปกติ";
        }
        return discountStrategy.getStrategyName();
    }
    public void setStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
}
