package com.twu.refactoring;

/**
 * OrderReceipt prints the details of order including customer name, address, description, quantity,
 * price and amount. It also calculates the sales tax @ 10% and prints as part
 * of order. It computes the total order amount (amount of individual lineItems +
 * total sales tax) and prints it.
 */
public class OrderReceipt {
    public static final double TAX_RATE = .10;
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();

        // print headers
        output.append("======Printing Orders======\n");

        // print date, bill no, customer name
//        output.append("Date - " + order.getDate();
        appendCustomerInfo(output);
//        output.append(order.getCustomerLoyaltyNumber());

        // prints lineItems
        appendLineItemInfo(output);
        return output.toString();
    }

    private void appendLineItemInfo(StringBuilder output) {
        double totalSalesTax = 0d;
        double totalAmount = 0d;
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

        for (LineItem lineItem : order.getLineItems()) {
            double salesTax = lineItem.totalAmount() * TAX_RATE;
            totalSalesTax += salesTax;
            totalAmount += lineItem.totalAmount() + salesTax;
        }
        // prints the state tax
        output.append("Sales Tax").append('\t').append(totalSalesTax);

        // print total amount
        output.append("Total Amount").append('\t').append(totalAmount);
    }

    private void appendCustomerInfo(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
    }
}