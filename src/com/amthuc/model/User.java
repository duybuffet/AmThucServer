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
public class User {

    private int id;
    private String username;
    private String password;
    private int userLevel;
    private int status;
    private String fullName;
    private String phone;
    public User() {
    }

    public User(int id, String username, String password, int userLevel, int status, String fullName, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
        this.status = status;
        this.fullName = fullName;
        this.phone = phone;
    }

    public User(int id, String username, String password, int userLevel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
    }

    public User(int id, String username, String password, int userLevel, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
        this.status = status;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", userLevel=" + userLevel + '}';
    }
}
