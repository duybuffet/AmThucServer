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

    public User() {
    }

    public User(int id, String username, String password, int userLevel, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
        this.status = status;
    }

    public User(int id, String username, String password, int userLevel) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userLevel = userLevel;
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

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", username=" + username + ", userLevel=" + userLevel + '}';
    }
}
