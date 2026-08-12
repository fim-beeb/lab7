package com.example.lab7_6733804228_sec3.model;

import com.example.lab7_6733804228_sec3.strategy.*;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Game")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String title;
    private String genre;
    private String platform;
    private double rating;
    private LocalDate releaseDate;
    private double price;
    private String discountType;

    public Game() {
    }

    public Game(String title, String genre, String platform, double rating, LocalDate releaseDate, double price, String discountType) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.price = price;
        this.discountType = discountType;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscountType() {
        return this.discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", title='" + getTitle() + "'" +
            ", genre='" + getGenre() + "'" +
            ", platfrom='" + getPlatform() + "'" +
            ", rating='" + getRating() + "'" +
            ", releaseDate='" + getReleaseDate() + "'" +
            ", price='" + getPrice() + "'" +
            ", discountType='" + getDiscountType() + "'" +
            "}";
    }

    public DiscountStrategy getStrategyInstance() {
        if ("STUDENT".equalsIgnoreCase(this.discountType)) {
            return new StudentDiscountStrategy();
        } else if ("SEASONAL".equalsIgnoreCase(this.discountType)) {
            return new SeasonalSaleStrategy();
        } else {
            return new NoDiscountStrategy();
        }
    }

    public double getFinalPrice() {
        DiscountContext context = new DiscountContext();
        context.setStrategy(getStrategyInstance());
        return context.executeStrategy(this.price);
    }

    public String getDiscountName() {
        DiscountContext context = new DiscountContext();
        context.setStrategy(getStrategyInstance());
        return context.getStrategyName();
    }
    
}
