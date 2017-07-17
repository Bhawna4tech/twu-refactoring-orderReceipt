package com.twu.refactoring;

public class OrderReceipt {
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
        order.printLineItemInfomation(output);
        order.printSalesTaxAndAmount(output);
    }

}