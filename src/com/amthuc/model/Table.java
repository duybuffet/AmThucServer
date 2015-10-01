/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.model;

import javax.swing.JLabel;

/**
 *
 * @author Pia
 */
public class Table extends JLabel {

    private int id;
    private String name;
    private int area;
    private int type;

    public Table(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Table(int id, String name, int area) {
        this.id = id;
        this.name = name;
        this.area = area;
    }

    public Table(int id, String name, int area, int type) {
        this.id = id;
        this.name = name;
        this.area = area;
        this.type = type;
    }

    public int getArea() {
        return area;
    }

    public void setArea(int area) {
        this.area = area;
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

    @Override
    public String toString() {
        return "Table{" + "id=" + id + ", name=" + name + ", area=" + area + ", type=" + type + '}';
    }

}
