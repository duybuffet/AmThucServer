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
public class OrderDetails {

    private int id;
    private float displayPrice;
    private int quantity;
    private Order order;
    private Dish dish;

    public OrderDetails() {
    }

    public OrderDetails(int id) {
        this.id = id;
    }

    public OrderDetails(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public OrderDetails(float displayPrice, int quantity, Dish dish) {
        this.displayPrice = displayPrice;
        this.quantity = quantity;
        this.dish = dish;
    }

    public OrderDetails(float displayPrice, int quantity, Order order, Dish dish) {
        this.displayPrice = displayPrice;
        this.quantity = quantity;
        this.order = order;
        this.dish = dish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getDisplayPrice() {
        return displayPrice;
    }

    public void setDisplayPrice(float displayPrice) {
        this.displayPrice = displayPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

}
