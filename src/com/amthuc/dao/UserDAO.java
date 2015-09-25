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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pia
 */
public class UserDAO {

    public List<User> getAll() {
        List<User> result = null;

        return result;
    }

    public User get(int id) throws ClassNotFoundException, SQLException {
        User user = null;
        String query = "SELECT username, user_level FROM tbl_user WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(id);
            user.setUsername(rs.getString("username"));
            user.setUserLevel(rs.getInt("user_level"));
            return user;
        }

        return user;
    }

    public boolean insert(User user) throws ClassNotFoundException, SQLException {
        User u = login(user);
        if (u == null) {
            String query = "INSERT INTO tbl_user (username,password,user_level) VALUES(?,?,?)";
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUserLevel());
            ps.executeUpdate();
            return true;
        }
        return false;
    }

    public void update(User user) {

    }

    public void delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_user WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    public User login(User user) throws SQLException, ClassNotFoundException {
        User u = null;
        String query = "SELECT * FROM tbl_user WHERE username = ? AND password = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            u = new User(rs.getInt("id"),
                    rs.getString("username"), rs.getString("password"),
                    rs.getInt("user_level"));
        }
        return u;
    }
    
    public static void main(String[] args) {
        try {
            User user = new User();
            user.setPassword("123456");
            user.setUsername("duy");
            UserDAO dao = new UserDAO();
            User res = dao.login(user);
            System.out.println(res.getUsername());
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
