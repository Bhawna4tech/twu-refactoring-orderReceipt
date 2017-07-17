package com.twu.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;
    private static final double TAX_RATE = .10;

    Order(String customerName, String customerAddress, List<LineItem> lineItems) {
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.lineItems = lineItems;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    void printCustomerInfo(StringBuilder output) {
        output.append(customerName);
        output.append(customerAddress);
    }

    void printLineItemInfomation(StringBuilder output) {
        for (LineItem lineItem : lineItems) {
            lineItem.printInformation(output);
        }
    }

    private double getTotalSales() {
        double sum = 0.0;
        for (LineItem lineItem : lineItems) {
            double v = lineItem.totalAmount();
            sum += v;
        }
        return sum;
    }

    void printSalesTaxAndAmount(StringBuilder output) {
        double totalSalesTax = getTotalSales() * TAX_RATE;
        double totalAmount = getTotalAmount();

        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private double getTotalAmount() {
        return (1 + (TAX_RATE)) * getTotalSales();
    }
}
