package com.twu.refactoring;

import java.util.List;

public class Order {
    private String customerName;
    private String customerAddress;
    private List<LineItem> lineItems;

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

    List<LineItem> getLineItems() {
        return lineItems;
    }

    void printCustomerInfo(StringBuilder output) {
        output.append(customerName);
        output.append(customerAddress);
    }
}
