package com.mycompany.klinik_hewan.controller;

import com.mycompany.klinik_hewan.model.User;
import com.mycompany.utils.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AuthController {

    public User login(String username, String password) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("username");
                String pass = rs.getString("password");
                String role = rs.getString("role");
                return new User(id, uname, pass, role);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; // login gagal
    }
}
