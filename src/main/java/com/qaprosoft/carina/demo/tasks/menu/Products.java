package com.qaprosoft.carina.demo.tasks.menu;


public class Products implements Comparable<Products> {
    private String name;
    private int price;


    public Products(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "(" + name + ", " + price + ")";
    }


    @Override
    public int compareTo(Products o) {
        if (this.getPrice() < o.getPrice())
            return 1;
        else if (this.getPrice() > o.getPrice())
            return -1;
        else
            return 0;
    }
}