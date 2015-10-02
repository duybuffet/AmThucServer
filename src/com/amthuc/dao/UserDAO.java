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
public class UserDAO {

    public List<User> getAll(int exceptUserId) throws ClassNotFoundException, SQLException {
        List<User> result = new ArrayList<>();
        User user = null;
        String query = "SELECT * FROM tbl_user WHERE id != ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, exceptUserId);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setFullName(rs.getString("fullname"));
            user.setPhone(rs.getString("phone"));
            user.setUserLevel(rs.getInt("user_level"));
            user.setPassword(rs.getString("password"));
            result.add(user);
        }
        return result;
    }

    public User get(int id) throws ClassNotFoundException, SQLException {
        User user = null;
        String query = "SELECT * FROM tbl_user WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            user = new User();
            user.setId(id);
            user.setUsername(rs.getString("username"));
            user.setUserLevel(rs.getInt("user_level"));
            user.setFullName(rs.getString("fullname"));
            user.setPhone(rs.getString("phone"));
            user.setPassword(rs.getString("password"));
            return user;
        }

        return user;
    }

    public boolean insert(User user) throws ClassNotFoundException, SQLException {
        if (!checkExist(user)) {
            String query = "INSERT INTO tbl_user (username,password,user_level,fullname,phone) VALUES(?,?,?,?,?)";
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setInt(3, user.getUserLevel());
            ps.setString(4, user.getFullName());
            ps.setString(5, user.getPhone());
            ps.executeUpdate();
            return true;
        }
        return false;
    }

    public int update(User user) throws SQLException, ClassNotFoundException {
        User oldProfile = get(user.getId());
        System.out.println("Found user old : " + oldProfile.getUsername());
        System.out.println("User update : " + user.getUsername());
        if (oldProfile != null) {
            if (!oldProfile.getUsername().equals(user.getUsername()) && checkExist(user)) {
                return 0;
            }
            String query = "UPDATE tbl_user SET username = ?,fullname = ?,phone = ?, password = ? WHERE id = ?";
            PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getFullName());
            ps.setString(3, user.getPhone());
            ps.setString(4, user.getPassword());
            ps.setInt(5, user.getId());
            return ps.executeUpdate();
        }
        return 0;

    }

    public int delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_user WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }

    public User login_admin(User user) throws SQLException, ClassNotFoundException {
        User u = null;
        System.out.println("name " + user.getUsername());
        System.out.println("pass " + user.getPassword());
        
        String query = "SELECT * FROM tbl_user WHERE username = ? AND password = ? AND user_level = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, user.getUsername());
        ps.setString(2, user.getPassword());
        ps.setInt(3, GLOBAL.USER_LEVEL.ADMIN);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            u = new User(rs.getInt("id"),
                    rs.getString("username"), rs.getString("password"),
                    rs.getInt("user_level"));
        }
        return u;
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
    
    public boolean checkExist(User user) throws ClassNotFoundException, SQLException {
        String query = "SELECT id FROM tbl_user WHERE username = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, user.getUsername());
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            return true;
        }
        return false;
    }
}
