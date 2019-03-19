package com.katas;


import java.math.BigDecimal;

/**
 * Volume of Harry Potter Book
 * */
public class Book {

    private String title;
    private Double price;

    public Book(String title, Double price){
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object obj) {
        boolean res = false;

        if (obj!=null && obj instanceof Book){
            res = this.title == ((Book) obj).getTitle();
        }

        return res;
    }
}