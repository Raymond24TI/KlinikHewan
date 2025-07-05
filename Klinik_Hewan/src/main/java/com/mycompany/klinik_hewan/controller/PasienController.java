package com.mycompany.klinik_hewan.controller;

import com.mycompany.klinik_hewan.model.Pasien;
import com.mycompany.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PasienController {

    // Tambah pasien baru
    public boolean tambahPasien(Pasien pasien) {
        String sql = "INSERT INTO pasien (namadepan, namabelakang, nhewan, kelamin, umur, spesies, kontak, alamat, nohp, email, keluhan) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, pasien.getNamaDepan());
            stmt.setString(2, pasien.getNamaBelakang());
            stmt.setString(3, pasien.getNamaHewan());
            stmt.setString(4, pasien.getKelamin());
            stmt.setInt(5, pasien.getUmur());
            stmt.setString(6, pasien.getSpesies());
            stmt.setString(7, pasien.getKontak());
            stmt.setString(8, pasien.getAlamat());
            stmt.setString(9, pasien.getNoHp());
            stmt.setString(10, pasien.getEmail());
            stmt.setString(11, pasien.getKeluhan());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Cari pasien berdasarkan nama
    public List<Pasien> cariPasien(String keyword) {
        List<Pasien> hasil = new ArrayList<>();
        String sql = "SELECT * FROM pasien WHERE namadepan LIKE ? OR namabelakang LIKE ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, "%" + keyword + "%");
            stmt.setString(2, "%" + keyword + "%");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Pasien pasien = new Pasien(
                    rs.getInt("id"),
                    rs.getString("namadepan"),
                    rs.getString("namabelakang"),
                    rs.getString("nhewan"),
                    rs.getString("kelamin"),
                    rs.getInt("umur"),
                    rs.getString("spesies"),
                    rs.getString("kontak"),
                    rs.getString("alamat"),
                    rs.getString("nohp"),
                    rs.getString("email"),
                    rs.getString("keluhan")
                );
                hasil.add(pasien);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return hasil;
    }

    // Ambil semua data pasien
    public List<Pasien> getSemuaPasien() {
        List<Pasien> daftar = new ArrayList<>();
        String sql = "SELECT * FROM pasien ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pasien pasien = new Pasien(
                    rs.getInt("id"),
                    rs.getString("namadepan"),
                    rs.getString("namabelakang"),
                    rs.getString("nhewan"),
                    rs.getString("kelamin"),
                    rs.getInt("umur"),
                    rs.getString("spesies"),
                    rs.getString("kontak"),
                    rs.getString("alamat"),
                    rs.getString("nohp"),
                    rs.getString("email"),
                    rs.getString("keluhan")
                );
                daftar.add(pasien);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return daftar;
    }
}
