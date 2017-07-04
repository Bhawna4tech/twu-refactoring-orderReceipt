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

	String getDescription() {
		return description;
	}

	double getPrice() {
		return price;
	}

	int getQuantity() {
		return quantity;
	}

    double totalAmount() {
        return price * quantity;
    }
}