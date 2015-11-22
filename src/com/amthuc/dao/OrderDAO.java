/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.dao;

import com.amthuc.model.*;
import com.amthuc.utils.DBConnect;
import com.amthuc.utils.GLOBAL;
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
public class OrderDAO {

    public List<Order> getAll() throws SQLException, ClassNotFoundException {
        List<Order> result = new ArrayList<>();
        Order order = null;
        String query = "SELECT * FROM tbl_order ORDER BY status, order_time DESC";
        TableDAO tblDao = new TableDAO();
        OrderDetailsDAO detailsDao = new OrderDetailsDAO();

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderTable(tblDao.get(rs.getInt("order_table")));
            order.setDescription(rs.getString("description"));
            order.setTotalCost(rs.getDouble("total_cost"));
            order.setOrderTime(rs.getString("order_time"));
            order.setStatus(rs.getInt("status"));
            order.setPantryCompleteTime(rs.getString("pantry_complete_time"));
            order.setItems(detailsDao.getByOrder(order.getId()));
            result.add(order);
        }
        return result;
    }

    public Order get(int id) throws ClassNotFoundException, SQLException {
        Order order = null;
        String query = "SELECT * FROM tbl_order WHERE id = ?";
        TableDAO tblDao = new TableDAO();
        OrderDetailsDAO detailsDao = new OrderDetailsDAO();
        UserDAO uDao = new UserDAO();

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
            order.setStatus(rs.getInt("status"));
            order.setItems(detailsDao.getByOrder(id));
            order.setWaiter(uDao.get(rs.getInt("waiter_id")));
            return order;
        }
        return order;
    }

    public Order getOrderByTableID(int tableId) throws ClassNotFoundException, SQLException {
        Order order = null;
        String query = "SELECT * FROM tbl_order "
                + "WHERE order_table = ? AND status IN (?,?,?) "
                + "ORDER BY order_time DESC LIMIT 1";
        TableDAO tblDao = new TableDAO();
        OrderDetailsDAO detailsDao = new OrderDetailsDAO();
        UserDAO uDao = new UserDAO();

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, tableId);
        ps.setInt(2, GLOBAL.ORDER_AND_TABLE_STATUS.ORDERED);
        ps.setInt(3, GLOBAL.ORDER_AND_TABLE_STATUS.ORDER_READY_TO_SERVED);
        ps.setInt(4, GLOBAL.ORDER_AND_TABLE_STATUS.ORDER_SERVED);
        
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            order = new Order();
            order.setId(rs.getInt("id"));
            order.setOrderTable(tblDao.get(rs.getInt("order_table")));
            order.setDescription(rs.getString("description"));
            order.setTotalCost(rs.getDouble("total_cost"));
            order.setOrderTime(rs.getString("order_time"));
            order.setPantryCompleteTime(rs.getString("pantry_complete_time"));
            order.setStatus(rs.getInt("status"));
            order.setItems(detailsDao.getByOrder(order.getId()));
            order.setWaiter(uDao.get(rs.getInt("waiter_id")));
            return order;
        }
        return order;
    }

    public void insert(Order order) throws ClassNotFoundException, SQLException {
        try {
            TableDAO tblDao = new TableDAO();
            OrderDetailsDAO odetailDao = new OrderDetailsDAO();
            String query = "INSERT INTO tbl_order (order_table,description,total_cost,pantry_complete_time, status, waiter_id, order_time) VALUES(?,?,?,?,?,?, NOW())";
            DBConnect.getConnection().setAutoCommit(false);
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
            ps.setInt(1, order.getOrderTable().getId());
            ps.setString(2, order.getDescription());
            ps.setDouble(3, order.getTotalCost());
            ps.setString(4, order.getPantryCompleteTime());
            ps.setInt(5, order.getStatus());
            ps.setInt(6, order.getWaiter().getId());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                order.setId(id);
                for (OrderDetails od : order.getItems()) {
                    od.setOrder(order);
                    odetailDao.insert(od, id);
                }
                DBConnect.getConnection().commit();
            } else {
                return;
            }

        } catch (SQLException ex) {
            DBConnect.getConnection().rollback();
            ex.printStackTrace();
        } finally {
            DBConnect.getConnection().setAutoCommit(true);
        }
    }

    public void update(Order order) throws ClassNotFoundException, SQLException {
        String query = "UPDATE tbl_order SET order_table = ?,description = ?,total_cost = ?,pantry_complete_time = ?, status = ? WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, order.getOrderTable().getId());
        ps.setString(2, order.getDescription());
        ps.setDouble(3, order.getTotalCost());
        ps.setString(4, order.getPantryCompleteTime());
        ps.setInt(5, order.getStatus());
        ps.setInt(6, order.getId());
        ps.executeUpdate();
    }
    
    public void cancel(Order order) throws ClassNotFoundException, SQLException {
        OrderDetailsDAO odDao = new OrderDetailsDAO();
        String query = "UPDATE tbl_order SET status = ? WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, GLOBAL.ORDER_AND_TABLE_STATUS.ORDER_CANCEL);        
        ps.setInt(2, order.getId());
        for (OrderDetails od : odDao.getByOrder(order.getId())) {
            odDao.delete(od);
        }
        ps.executeUpdate();
    }

    public void delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_order WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public static void main(String[] args) {
        try {
//            Order order = new Order(2, new Table(2, ""), "nothing in ur eyes", 7.0, 2, "2016-10-20 11:12:49", "2017-10-20 11:12:49", new User(5, null, null, 1));
//            OrderDetails detail = new OrderDetails(0, 2, order, new Dish(1));
//            order.getItems().add(detail);
//            Order o = new Order();
//            o.setId(42);
            System.out.println(new OrderDAO().get(69).getStatus());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
