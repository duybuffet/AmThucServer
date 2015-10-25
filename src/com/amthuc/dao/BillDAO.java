/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.dao;

import com.amthuc.model.Bill;
import com.amthuc.model.Order;
import com.amthuc.utils.DBConnect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pia
 */
public class BillDAO {
    public void insert(Bill bill) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO tbl_bill (time,customer_money,customer_change, order_id) VALUES(?,?,?,?)";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, bill.getTime());
        ps.setFloat(2, bill.getCustomerMoney());
        ps.setFloat(3, bill.getCustomerChange());
        ps.setInt(4, bill.getOrder().getId());
        ps.executeUpdate();
    }
    
    public Bill get(int id) throws ClassNotFoundException, SQLException {
        Bill res = null;
        String query = "SELECT * FROM tbl_bill WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            res = new Bill();
            res.setId(id);
            res.setCustomerChange(rs.getFloat("customer_change"));
            res.setCustomerMoney(rs.getFloat("customer_money"));
            res.setOrder(new OrderDAO().get(rs.getInt("order_id")));            
            res.setTime(rs.getString("time"));
        }

        return res;
    }
    
    public List<Bill> getAll() throws ClassNotFoundException, SQLException {
        List<Bill> list = new ArrayList<Bill>();
        String query = "SELECT * FROM tbl_bill";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Bill res = new Bill();
            res.setId(rs.getInt("id"));
            res.setCustomerChange(rs.getFloat("customer_change"));
            res.setCustomerMoney(rs.getFloat("customer_money"));
            res.setOrder(new OrderDAO().get(rs.getInt("order_id")));            
            res.setTime(rs.getString("time"));
            
            list.add(res);
        }
        return list;
    }        
}
