package com.company.menu.products;

public class Meat {

    String nameProduct;
    int priceProduct;
    String description;

    public Meat(String nameProduct, int priceProduct, String description) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Meat{" +
                "nameProduct='" + nameProduct + '\'' +
                ", priceProduct=" + priceProduct +
                ", description='" + description + '\'' +
                '}';
    }
}
