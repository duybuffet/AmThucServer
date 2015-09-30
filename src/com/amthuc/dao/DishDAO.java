/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.dao;

import com.amthuc.model.*;
import com.amthuc.utils.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pia
 */
public class DishDAO {
    public List<Dish> getAll() throws ClassNotFoundException, SQLException {
        List<Dish> result = new ArrayList<>();
        Dish dish = null;
        String query = "SELECT * FROM tbl_dish";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        System.out.println("Vao");
        while (rs.next()) {
            dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setPrice(rs.getFloat("price"));
            dish.setUnit(rs.getString("unit"));
            dish.setCategory(new Category(rs.getInt("category_id")));
            result.add(dish);
        }
        return result;
    }
    
    public List<Dish> getByCategory(int categoryId) throws ClassNotFoundException, SQLException {
        List<Dish> result = new ArrayList<>();
        Dish dish = null;
        String query = "SELECT * FROM tbl_dish WHERE category_id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, categoryId);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            dish = new Dish();
            dish.setId(rs.getInt("id"));
            dish.setName(rs.getString("name"));
            dish.setPrice(rs.getFloat("price"));
            dish.setUnit(rs.getString("unit"));
            dish.setCategory(new Category(rs.getInt("category_id")));
            result.add(dish);
        }
        return result;
    }
    
    public Dish get(int id) throws ClassNotFoundException, SQLException {
        Dish dish = null;
        String query = "SELECT * FROM tbl_dish WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            dish = new Dish();
            dish.setId(id);
            dish.setName(rs.getString("name"));
            dish.setPrice(rs.getFloat("price"));
            dish.setUnit(rs.getString("unit"));
            dish.setCategory(new Category(rs.getInt("category_id")));
            return dish;
        }
        return dish;
    }
    
    public int insert(Dish dish) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO tbl_dish (name,price,unit,category_id) VALUES(?,?,?,?)";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, dish.getName());
        ps.setDouble(2, dish.getPrice());
        ps.setString(3, dish.getUnit());
        ps.setInt(4, dish.getCategory().getId());
        return ps.executeUpdate();
    }
    
    public int update(Dish dish) throws ClassNotFoundException, SQLException {
        String query = "UPDATE tbl_dish SET name = ?,price = ?,unit = ?,category_id = ? WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, dish.getName());
        ps.setDouble(2, dish.getPrice());
        ps.setString(3, dish.getUnit());
        ps.setInt(4, dish.getCategory().getId());
        ps.setInt(5, dish.getId());
        return ps.executeUpdate();
    }
    
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_dish WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }
}
