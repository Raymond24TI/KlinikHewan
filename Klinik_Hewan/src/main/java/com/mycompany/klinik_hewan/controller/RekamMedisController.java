package com.mycompany.klinik_hewan.controller;

import com.mycompany.klinik_hewan.model.RekamMedis;
import com.mycompany.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RekamMedisController {

    // Tambah rekam medis baru (oleh staff)
    public boolean tambahRekam(RekamMedis rekam) {
        String sql = "INSERT INTO rekam_medis (id_pasien, keluhan, status) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, rekam.getIdPasien());
            stmt.setString(2, rekam.getKeluhan());
            stmt.setString(3, rekam.getStatus());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Update diagnosa, obat, takaran oleh dokter
    public boolean updateRekam(RekamMedis rekam) {
        String sql = "UPDATE rekam_medis SET diagnosa = ?, obat = ?, takaran = ?, status = ? WHERE id_rekam = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, rekam.getDiagnosa());
            stmt.setString(2, rekam.getObat());
            stmt.setString(3, rekam.getTakaran());
            stmt.setString(4, rekam.getStatus()); // biasanya "ditangani"
            stmt.setInt(5, rekam.getIdRekam());

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Ambil daftar rekam medis berdasarkan status (baru / ditangani / selesai)
    public List<RekamMedis> getRekamByStatus(String status) {
        List<RekamMedis> list = new ArrayList<>();
        String sql = "SELECT * FROM rekam_medis WHERE status = ? ORDER BY tanggal DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RekamMedis rekam = new RekamMedis(
                    rs.getInt("id_rekam"),
                    rs.getInt("id_pasien"),
                    rs.getString("keluhan"),
                    rs.getString("diagnosa"),
                    rs.getString("obat"),
                    rs.getString("takaran"),
                    rs.getString("status"),
                    rs.getTimestamp("tanggal")
                );
                list.add(rekam);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    // Ambil riwayat rekam medis berdasarkan pasien
    public List<RekamMedis> getRekamByPasien(int idPasien) {
        List<RekamMedis> list = new ArrayList<>();
        String sql = "SELECT * FROM rekam_medis WHERE id_pasien = ? ORDER BY tanggal DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idPasien);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                RekamMedis rekam = new RekamMedis(
                    rs.getInt("id_rekam"),
                    rs.getInt("id_pasien"),
                    rs.getString("keluhan"),
                    rs.getString("diagnosa"),
                    rs.getString("obat"),
                    rs.getString("takaran"),
                    rs.getString("status"),
                    rs.getTimestamp("tanggal")
                );
                list.add(rekam);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
