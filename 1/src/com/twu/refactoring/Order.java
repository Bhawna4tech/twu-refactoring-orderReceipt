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
        return lineItems.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    void printSalesTaxAndAmount(StringBuilder output) {
        output.append("Sales Tax").append('\t').append(getTax());
        output.append("Total Amount").append('\t').append(getTotalAmount());
    }

    private double getTax() {
        return getTotalSales() * TAX_RATE;
    }

    private double getTotalAmount() {
        return getTax() + getTotalSales();
    }
}
