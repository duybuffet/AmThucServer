/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.model;

/**
 *
 * @author Pia
 */
public class Dish {
    private int id;
    private String name;
    private String description;
    private boolean isEnable;
    private float price;
    private String unit;
    private int discount;    
    private String image;
    private Category category;

    public Dish() {
    }

    public Dish(int id) {
        this.id = id;
    }
    
    public Dish(int id, String name, String description, boolean isEnable, float price, String unit, int discount, String image) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isEnable = isEnable;
        this.price = price;
        this.unit = unit;
        this.discount = discount;
        this.image = image;
    }

    public Dish(int id, String name, String description, boolean isEnable, float price, String unit, int discount, String image, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isEnable = isEnable;
        this.price = price;
        this.unit = unit;
        this.discount = discount;
        this.image = image;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isIsEnable() {
        return isEnable;
    }

    public void setIsEnable(boolean isEnable) {
        this.isEnable = isEnable;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }   
}
