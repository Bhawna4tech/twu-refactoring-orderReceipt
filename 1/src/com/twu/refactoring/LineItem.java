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

	public void printInformation(StringBuilder output) {
        output.append(getDescription());
        output.append('\t');
        output.append(getPrice());
        output.append('\t');
        output.append(getQuantity());
        output.append('\t');
        output.append(totalAmount());
        output.append('\n');
    }
}