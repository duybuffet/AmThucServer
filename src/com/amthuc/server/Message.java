package com.amthuc.server;

import com.amthuc.model.Bill;
import com.amthuc.model.Category;
import com.amthuc.model.Dish;
import com.amthuc.model.Order;
import com.amthuc.model.OrderDetails;
import com.amthuc.model.Table;
import com.amthuc.model.User;
import java.util.ArrayList;
import java.util.List;

public class Message {
    // id của message, các id này được định nghĩa trong com.amthuc.utils.GLOBAL
    private int msgID;
    // Nội dung thông điệp
    private String msg;
    
    // muốn gửi và nhận dữ liệu gì thì set giá trị cho thuộc tính đó 
    // ví dụ có thể gửi và nhận 1 user, 1 mảng các user, 1 danh mục, 1 mảng các danh mục,...
    private User user;
    private ArrayList<User> arrUsers;
    private User target;
    private List<Category> arrCategories;
    private List<Dish> arrDishes;
    private List<Table> arrTables;
    private List<OrderDetails> arrOrderDetails;
    private Order order;
    private Bill bill;
    private OrderDetails orderDetails;

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public Message() {
        super();
    }

    public Message(int msgID, ArrayList<User> arrUsers) {
        super();
        this.msgID = msgID;
        this.arrUsers = arrUsers;
    }

    public ArrayList<User> getArrUsers() {
        return arrUsers;
    }

    public void setArrUsers(ArrayList<User> arrUsers) {
        this.arrUsers = arrUsers;
    }

    public Message(int msgID, String msg, User user,
            ArrayList<User> arrUsers) {
        super();
        this.msgID = msgID;
        this.msg = msg;
        this.user = user;
        this.arrUsers = arrUsers;
    }

    public Message(int msgID, String msg, ArrayList<User> arrUsers) {
        super();
        this.msgID = msgID;
        this.msg = msg;
        this.arrUsers = arrUsers;
    }

    public Message(int msgID, String msg) {
        super();
        this.msgID = msgID;
        this.msg = msg;
    }

    public Message(int msgID, String msg, User user) {
        super();
        this.msgID = msgID;
        this.msg = msg;
        this.user = user;
    }

    public int getMsgID() {
        return msgID;
    }

    public void setMsgID(int msgID) {
        this.msgID = msgID;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Category> getArrCategories() {
        return arrCategories;
    }

    public void setArrCategories(List<Category> arrCategories) {
        this.arrCategories = arrCategories;
    }

    public List<Dish> getArrDishes() {
        return arrDishes;
    }

    public void setArrDishes(List<Dish> arrDishes) {
        this.arrDishes = arrDishes;
    }

    public List<Table> getArrTables() {
        return arrTables;
    }

    public void setArrTables(List<Table> arrTables) {
        this.arrTables = arrTables;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public OrderDetails getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(OrderDetails orderDetails) {
        this.orderDetails = orderDetails;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<OrderDetails> getArrOrderDetails() {
        return arrOrderDetails;
    }

    public void setArrOrderDetails(List<OrderDetails> arrOrderDetails) {
        this.arrOrderDetails = arrOrderDetails;
    }

}
