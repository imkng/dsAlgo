package com.company.solidPriciple;

public class Invoice {
    private Marker marker;
    int quantity;

    public Invoice(Marker marker, int quantity) {
        this.marker = marker;
        this.quantity = quantity;
    }

    public static class Marker {
        int price;
        String color;

        public Marker(int price, String color) {
            this.price = price;
            this.color = color;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public static class InviceDao {
            com.company.solidPriciple.solid.withoutS.Invoice invoice;

            public InviceDao(com.company.solidPriciple.solid.withoutS.Invoice invoice) {
                this.invoice = invoice;
            }

            public void saveToDb(){
                //
            }
        }
    }
}
