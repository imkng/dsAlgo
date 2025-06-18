package com.company.solidPriciple.solid.withS;

import com.company.solidPriciple.solid.withoutS.Invoice;

public class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb(){

    }
}
