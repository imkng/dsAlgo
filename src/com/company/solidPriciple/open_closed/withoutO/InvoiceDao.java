package com.company.solidPriciple.open_closed.withoutO;

import com.company.solidPriciple.solid.withoutS.Invoice;

public class InvoiceDao {
    Invoice invoice;

    public InvoiceDao(Invoice invoice) {
        this.invoice = invoice;
    }

    public void saveToDb(){

    }

    public void saveToFile(){
        // not following o/c
    }
}
