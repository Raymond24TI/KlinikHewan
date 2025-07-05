package com.mycompany.klinik_hewan.controller;

import com.mycompany.klinik_hewan.model.RekamMedis;
import com.mycompany.utils.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StaffController {

    // Ambil rekam medis yang statusnya 'ditangani' atau 'selesai'
    public List<RekamMedis> getRekamSiapPembayaran() {
        List<RekamMedis> list = new ArrayList<>();
        String sql = "SELECT * FROM rekam_medis WHERE status IN ('ditangani', 'selesai') ORDER BY tanggal DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

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

    // Hitung total biaya dari rekam medis berdasarkan jumlah obat
    public int hitungBiaya(RekamMedis rekam) {
        int biayaKonsultasi = 50000;
        int biayaPerObat = 20000;

        // Pisahkan nama-nama obat berdasarkan koma
        String[] daftarObat = rekam.getObat() != null ? rekam.getObat().split(",") : new String[0];
        int jumlahObat = daftarObat.length;

        return biayaKonsultasi + (jumlahObat * biayaPerObat);
    }

    // Tandai rekam medis sudah selesai (setelah pembayaran)
    public boolean tandaiSelesai(int idRekam) {
        String sql = "UPDATE rekam_medis SET status = 'selesai' WHERE id_rekam = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, idRekam);
            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
}
