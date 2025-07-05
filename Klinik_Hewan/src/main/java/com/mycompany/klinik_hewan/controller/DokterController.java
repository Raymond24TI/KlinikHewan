package com.mycompany.klinik_hewan.controller;

import com.mycompany.klinik_hewan.model.Dokter;
import com.mycompany.utils.DBConnection;

import java.sql.*;

public class DokterController {

    // Login Dokter
    public Dokter login(String username, String password) {
        String sql = "SELECT * FROM dokter WHERE username = ? AND password = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Dokter(
                    rs.getInt("id_dokter"),
                    rs.getString("ndokter"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Ambil data dokter by ID (jika perlu)
    public Dokter getDokterById(int idDokter) {
        String sql = "SELECT * FROM dokter WHERE id_dokter = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idDokter);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Dokter(
                    rs.getInt("id_dokter"),
                    rs.getString("ndokter"),
                    rs.getString("username"),
                    rs.getString("password")
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
