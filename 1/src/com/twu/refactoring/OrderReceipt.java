package com.twu.refactoring;

public class OrderReceipt {
    private static final double TAX_RATE = .10;
    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        order.printCustomerInfo(output);
        printLineItemInfo(output);
        return output.toString();
    }

    private void printLineItemInfo(StringBuilder output) {
        printLineItemInfomation(output);

        double totalSalesTax = getTotalSales() * TAX_RATE;
        double totalAmount = getTotalAmount();

        output.append("Sales Tax").append('\t').append(totalSalesTax);
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private void printLineItemInfomation(StringBuilder output) {
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
        }
    }

    private double getTotalSales() {
        double totalSales = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSales += lineItem.totalAmount();
        }
        return totalSales;
    }

    private double getTotalAmount() {
        return (1 + (TAX_RATE)) * getTotalSales();
    }
}