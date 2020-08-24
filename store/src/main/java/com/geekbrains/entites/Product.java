package com.geekbrains.entites;

public class Product {

    private static int nextId=0;
    private int id;
    private String title;
    private int cost;

    public Product(String title, int cost) {
        this.id = nextId++;
        this.title = title;
        this.cost = cost;
    }

    public Product(){

    }



    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
