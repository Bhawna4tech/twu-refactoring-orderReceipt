package com.twu.refactoring;

public class LineItem {
    private String description;
    private double price;
    private int quantity;

    LineItem(String description, double price, int quantity) {
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    double totalAmount() {
        return price * quantity;
    }

    public String getInformation() {
        return description + "\t" + price + "\t" + quantity + "\t" + totalAmount() + "\n";
    }
}