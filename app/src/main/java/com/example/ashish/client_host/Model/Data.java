package com.example.ashish.client_host.Model;

public class Data {

    String imgUrl,name,price,foodName,foodUrl,nonVegUrl,nonVegName;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getNonVegUrl() {
        return nonVegUrl;
    }

    public void setNonVegUrl(String nonVegUrl) {
        this.nonVegUrl = nonVegUrl;
    }

    public String getNonVegName() {
        return nonVegName;
    }

    public void setNonVegName(String nonVegName) {
        this.nonVegName = nonVegName;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public String getFoodUrl() {
        return foodUrl;
    }

    public void setFoodUrl(String foodUrl) {
        this.foodUrl = foodUrl;
    }

    public Data()
    {}

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}