package com.company.javaeight.functionalInterfaces.supplierFunctionalInterface;

import java.util.function.Supplier;

public class SupplierFunctionalInterfaceDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = ()-> "Element Not found";

        System.out.println(supplier.get());
    }
}
