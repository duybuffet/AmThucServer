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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pia
 */
public class CategoryDAO {
    public List<Category> getAll() throws ClassNotFoundException, SQLException {
        List<Category> result = new ArrayList<Category>();
        Category category = null;
        String query = "SELECT * FROM tbl_category";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            category = new Category();
            category.setId(rs.getInt("id"));
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setImage(rs.getString("image"));
            result.add(category);
        }
        return result;
    }
    
    public Category get(int id) throws ClassNotFoundException, SQLException {
        Category category = null;
        String query = "SELECT * FROM tbl_category WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            category = new Category();
            category.setId(id);
            category.setName(rs.getString("name"));
            category.setDescription(rs.getString("description"));
            category.setImage(rs.getString("image"));
            return category;
        }

        return category;
    }
    
    public int insert(Category category) throws ClassNotFoundException, SQLException {
        String query = "INSERT INTO tbl_category (name,description,image) VALUES(?,?,?)";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, category.getName());
        ps.setString(2, category.getDescription());
        ps.setString(3, category.getImage());
        return ps.executeUpdate();
        
    }
    
    public int update(Category category) throws ClassNotFoundException, SQLException {
        String query = "UPDATE tbl_category SET name = ?,description = ?,image = ? WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setString(1, category.getName());
        ps.setString(2, category.getDescription());
        ps.setString(3, category.getImage());
        ps.setInt(4, category.getId());
        return ps.executeUpdate();
    }
    
    public int delete(int id) throws ClassNotFoundException, SQLException {
        String query = "DELETE FROM tbl_category WHERE id = ?";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        return ps.executeUpdate();
    }
    
    public static void main(String[] args) {
        try {
            Category cate = new Category();
            cate.setName("txtName.toString().trim()");
            cate.setDescription("txtDesc.toString().trim()");
            cate.setImage("day la hinh anh");
            
            CategoryDAO dao = new CategoryDAO();
            dao.insert(cate);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
