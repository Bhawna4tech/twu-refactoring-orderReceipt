package com.twu.refactoring;

import java.io.FileOutputStream;

public class OrderReceipt {
    private Order order;

    OrderReceipt(Order order) {
        this.order = order;
    }

    String printReceipt() {
        StringBuilder output = new StringBuilder();

        output.append("======Printing Orders======\n");

        output.append(order.printCustomerInfo());
        order.printLineItemInfomation(output);
        output.append(order.printSalesTaxAndAmount());
        return output.toString();
    }
}