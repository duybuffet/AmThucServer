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
public class OrderDAO {
    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        List<Order> result = new ArrayList<>();
        Order order = null;
        String query = "SELECT * FROM tbl_order";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderTable(rs.getString("order_table"));
            order.setDescription(rs.getString("description"));
            order.setTotalCost(rs.getDouble("total_cost"));
            order.setOrderTime(rs.getString("order_time"));
            order.setPantryCompleteTime(rs.getString("pantry_complete_time"));
            order.setDiscount(rs.getInt("discount"));
            order.setPayTime(rs.getString("pay_time"));
            result.add(order);
        }
        return result;
    }
    
    public Order get(int id) throws ClassNotFoundException, SQLException {
        Order order = null;
        String query = "SELECT * FROM tbl_order WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            order = new Order();
            order.setId(id);
            order.setOrderTable(rs.getString("order_table"));
            order.setDescription(rs.getString("description"));
            order.setTotalCost(rs.getDouble("total_cost"));
            order.setOrderTime(rs.getString("order_time"));
            order.setPantryCompleteTime(rs.getString("pantry_complete_time"));
            order.setDiscount(rs.getInt("discount"));
            order.setPayTime(rs.getString("pay_time"));
            return order;
        }
        return order;
    }
    
    public boolean insert(Order order) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO tbl_order (order_table,description,total_cost,order_time,pantry_complete_time,discount,pay_time) VALUES(?,?,?,?,?,?,?)";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, order.getOrderTable());
        ps.setString(2, order.getDescription());
        ps.setDouble(3, order.getTotalCost());
        ps.setString(4, order.getOrderTime());
        ps.setString(5, order.getPantryCompleteTime());
        ps.setInt(6, order.getDiscount());
        ps.setString(7, order.getPayTime());
        ps.executeUpdate();
        return true;
    } 
    
    public void update(Order order) throws ClassNotFoundException, SQLException {
        String query = "UPDATE tbl_order SET order_table =?,description =?,total_cost =?,order_time =?,pantry_complete_time =?,discount =?,pay_time =? WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, order.getOrderTable());
        ps.setString(2, order.getDescription());
        ps.setDouble(3, order.getTotalCost());
        ps.setString(4, order.getOrderTime());
        ps.setString(5, order.getPantryCompleteTime());
        ps.setInt(6, order.getDiscount());
        ps.setString(7, order.getPayTime());
        ps.setInt(8, order.getId());
        ps.executeUpdate();
    }        
    
    public void delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_order WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
