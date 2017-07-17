package com.twu.refactoring;

public class OrderReceipt {
    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(order.getCustomerInfo());
        order.printLineItemInfomation(output);
        output.append(order.getSalesTaxAndAmount());
        return output.toString();
    }
}