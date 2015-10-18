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
        TableDAO tblDao = new TableDAO();

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderTable(tblDao.get(rs.getInt("order_table")));
            order.setDescription(rs.getString("description"));
            order.setTotalCost(rs.getDouble("total_cost"));
            order.setOrderTime(rs.getString("order_time"));
            order.setPantryCompleteTime(rs.getString("pantry_complete_time"));
            result.add(order);
        }
        return result;
    }
    
    public Order get(int id) throws ClassNotFoundException, SQLException {
        Order order = null;
        String query = "SELECT * FROM tbl_order WHERE id = ?";
        TableDAO tblDao = new TableDAO();

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            order = new Order();
            order.setId(id);
            order.setOrderTable(tblDao.get(rs.getInt("order_table")));
            order.setDescription(rs.getString("description"));
            order.setTotalCost(rs.getDouble("total_cost"));
            order.setOrderTime(rs.getString("order_time"));
            order.setPantryCompleteTime(rs.getString("pantry_complete_time"));
            return order;
        }
        return order;
    }
    
    public boolean insert(Order order) throws ClassNotFoundException, SQLException {
        TableDAO tblDao = new TableDAO();
        String query = "INSERT INTO tbl_order (order_table,description,total_cost,order_time,pantry_complete_time) VALUES(?,?,?,?,?)";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, order.getOrderTable().getId());
        ps.setString(2, order.getDescription());
        ps.setDouble(3, order.getTotalCost());
        ps.setString(4, order.getOrderTime());
        ps.setString(5, order.getPantryCompleteTime());
        ps.executeUpdate();        
        return true;
    } 
    
    public void update(Order order) throws ClassNotFoundException, SQLException {
        String query = "UPDATE tbl_order SET order_table =?,description =?,total_cost =?,order_time =?,pantry_complete_time =? WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, order.getOrderTable().getId());
        ps.setString(2, order.getDescription());
        ps.setDouble(3, order.getTotalCost());
        ps.setString(4, order.getOrderTime());
        ps.setString(5, order.getPantryCompleteTime());
        ps.setInt(6, order.getId());
        ps.executeUpdate();
    }        
    
    public void delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_order WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }
}
