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

    String getCustomerInfo() {
        return customerName + customerAddress;
    }

    String getLineItemInfomation() {
        String lineItemInfo = "";
        for (LineItem lineItem : lineItems) {
            lineItemInfo += lineItem.getInformation();
        }
        return lineItemInfo;
    }

    private double getTotalSales() {
        return lineItems.stream().mapToDouble(LineItem::totalAmount).sum();
    }

    String getSalesTaxAndAmount() {
        return "Sales Tax" + "\t" + getTax() + "Total Amount" + "\t" + getTotalAmount();
    }

    private double getTax() {
        return getTotalSales() * TAX_RATE;
    }

    private double getTotalAmount() {
        return getTax() + getTotalSales();
    }
}
