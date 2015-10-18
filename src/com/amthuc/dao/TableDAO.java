/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amthuc.dao;

import com.amthuc.model.Table;
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
public class TableDAO {

    public Table get(int id) throws SQLException, ClassNotFoundException {
        Table tbl = null;
        String query = "SELECT * FROM tbl_table WHERE id = ?";

        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            tbl = new Table();
            tbl.setId(id);
            tbl.setName(rs.getString("name"));
            tbl.setArea(rs.getInt("area"));
            tbl.setType(rs.getInt("type"));
        }

        return tbl;
    }
    
    public List<Table> getAll() throws ClassNotFoundException, SQLException {
        List<Table> result = new ArrayList<>();
        Table tbl = null;
        String query = "SELECT * FROM tbl_table";
        PreparedStatement ps = DBConnect.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            tbl = new Table();
            tbl.setId(rs.getInt("id"));
            tbl.setName(rs.getString("name"));
            tbl.setArea(rs.getInt("area"));
            tbl.setType(rs.getInt("type"));
            result.add(tbl);
        }
        return result;
    }
}
