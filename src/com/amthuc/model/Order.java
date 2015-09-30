/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.model;

import java.util.List;

/**
 *
 * @author Pia
 */
public class Order {

    private int id;
    private String orderTable;
    private String description;
    private Double totalCost;
    private int status;
    private String orderTime;
    private String pantryCompleteTime;
    private String payTime;
    private int discount;
    private User waiter;
    private List<OrderDetails> items;

    public Order() {
    }

    public Order(int id) {
        this.id = id;
    }
    
    public Order(String orderTable, String description, Double totalCost, int status, String orderTime, String pantryCompleteTime, String payTime, int discount, User waiter) {
        this.orderTable = orderTable;
        this.description = description;
        this.totalCost = totalCost;
        this.status = status;
        this.orderTime = orderTime;
        this.pantryCompleteTime = pantryCompleteTime;
        this.payTime = payTime;
        this.discount = discount;
        this.waiter = waiter;
    }

    public Order(int id, String orderTable, String description, Double totalCost, int status, String orderTime, String pantryCompleteTime, String payTime, int discount, User waiter) {
        this.id = id;
        this.orderTable = orderTable;
        this.description = description;
        this.totalCost = totalCost;
        this.status = status;
        this.orderTime = orderTime;
        this.pantryCompleteTime = pantryCompleteTime;
        this.payTime = payTime;
        this.discount = discount;
        this.waiter = waiter;
    }

    public Order(String orderTable, String description, Double totalCost, int status, String orderTime, String pantryCompleteTime, String payTime, int discount, User waiter, List<OrderDetails> items) {
        this.orderTable = orderTable;
        this.description = description;
        this.totalCost = totalCost;
        this.status = status;
        this.orderTime = orderTime;
        this.pantryCompleteTime = pantryCompleteTime;
        this.payTime = payTime;
        this.discount = discount;
        this.waiter = waiter;
        this.items = items;
    }

    public Order(String orderTable, String description, Double totalCost, int status, String orderTime, String pantryCompleteTime, String payTime, int discount) {
        this.orderTable = orderTable;
        this.description = description;
        this.totalCost = totalCost;
        this.status = status;
        this.orderTime = orderTime;
        this.pantryCompleteTime = pantryCompleteTime;
        this.payTime = payTime;
        this.discount = discount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderTable() {
        return orderTable;
    }

    public void setOrderTable(String orderTable) {
        this.orderTable = orderTable;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getPantryCompleteTime() {
        return pantryCompleteTime;
    }

    public void setPantryCompleteTime(String pantryCompleteTime) {
        this.pantryCompleteTime = pantryCompleteTime;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public User getWaiter() {
        return waiter;
    }

    public void setWaiter(User waiter) {
        this.waiter = waiter;
    }

    public List<OrderDetails> getItems() {
        return items;
    }

    public void setItems(List<OrderDetails> items) {
        this.items = items;
    }

}
