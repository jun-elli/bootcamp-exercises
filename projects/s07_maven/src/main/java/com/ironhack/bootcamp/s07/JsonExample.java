package com.ironhack.bootcamp.s07;

import java.util.ArrayList;
import java.util.List;

public class JsonExample {
    /*
    Userº
   {
      "id": "YMZ-0000001",
      "total": 30.5,
      "isPaid": false,
      "invoiceItems": [
        { "name": "Coca Cola 2L", "price": "10" },
        { "name": "Rum Santa Teresa 0.7L", "price": "15" },
        { "name": "Ice bag L", "price": "5.5" }
      ]
    }
     */

    public static void main(String[] args) {
        Invoice invoice = new Invoice();
        invoice.id = "YMZ-0000001";
        invoice.total = 30.5f;
        invoice.isPaid = false;
        invoice.invoiceItems = new ArrayList<InvoiceItem>();
        InvoiceItem it1 = new InvoiceItem();
        it1.name = "";
        it1.price = "";
        invoice.invoiceItems.add(it1);
        invoice.invoiceItems.add(new InvoiceItem());
        invoice.invoiceItems.add(new InvoiceItem());
        invoice.invoiceItems.add(new InvoiceItem());

    }
}


class Invoice {
    String id;
    float total;
    boolean isPaid;
    List<InvoiceItem> invoiceItems;
}

class InvoiceItem {
    String name;
    String price;
}
