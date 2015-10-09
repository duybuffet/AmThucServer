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
public class OrderDetailsDAO {
    public List<OrderDetails> getByOrder(int orderId) throws ClassNotFoundException, SQLException {
        List<OrderDetails> result = new ArrayList<>();
        OrderDetails orderDetails = null;
        String query = "SELECT * FROM tbl_order_details";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            orderDetails = new OrderDetails();
            orderDetails.setId(rs.getInt("id"));
            orderDetails.setDisplayPrice(rs.getFloat("display_price"));
            orderDetails.setQuantity(rs.getInt("quantity"));
            orderDetails.setOrder(new Order(rs.getInt("order_id")));
            orderDetails.setDish(new Dish(rs.getInt("dish_id")));
            result.add(orderDetails);
        }
        return result;
    }
    
    public void insert(OrderDetails details) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO tbl_order_details (display_price,quantity,order_id,dish_id) VALUES(?,?,?,?)";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setFloat(1, details.getDisplayPrice());
        ps.setDouble(2, details.getQuantity());
        ps.setInt(3, details.getOrder().getId());
        ps.setInt(4, details.getDish().getId());
        ps.executeUpdate();
    }
}
