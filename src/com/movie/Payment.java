package com.movie;

public class Payment {
    private String method;
    private int price;

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String toString() {
        return "Method: " + method +
                "\n" + "Total price: " + price;
    }
}
