package com.mycompany.klinik_hewan.controller;

import com.mycompany.klinik_hewan.model.JadwalDokter;
import com.mycompany.utils.DBConnection;

import java.sql.*;
import java.util.*;

public class JadwalDokterController {

    private static final String[] HARI = {"Senin", "Selasa", "Rabu", "Kamis", "Jumat", "Sabtu"};
    private static final String[] JAM = {"08:00 - 12:00", "13:00 - 17:00"};

    // 🎲 Generate Jadwal Random
    public void generateJadwalRandom() {
        try (Connection conn = DBConnection.getConnection()) {
            // Ambil semua dokter
            String sqlDokter = "SELECT id_dokter FROM dokter";
            PreparedStatement stmtDokter = conn.prepareStatement(sqlDokter);
            ResultSet rs = stmtDokter.executeQuery();

            List<Integer> dokterIds = new ArrayList<>();
            while (rs.next()) {
                dokterIds.add(rs.getInt("id_dokter"));
            }

            // Kosongkan tabel jadwal lama
            String clear = "DELETE FROM jadwal_dokter";
            conn.createStatement().executeUpdate(clear);

            // Generate dan simpan jadwal baru
            Random rand = new Random();
            String sqlInsert = "INSERT INTO jadwal_dokter (id_dokter, hari, jam) VALUES (?, ?, ?)";
            PreparedStatement stmtInsert = conn.prepareStatement(sqlInsert);

            for (int id : dokterIds) {
                String hari = HARI[rand.nextInt(HARI.length)];
                String jam = JAM[rand.nextInt(JAM.length)];

                stmtInsert.setInt(1, id);
                stmtInsert.setString(2, hari);
                stmtInsert.setString(3, jam);
                stmtInsert.addBatch();
            }

            stmtInsert.executeBatch();
            System.out.println("✅ Jadwal dokter berhasil di-random!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // 📋 Ambil semua jadwal dokter + nama dokter
    public List<JadwalDokter> getJadwal() {
        List<JadwalDokter> list = new ArrayList<>();
        String sql = "SELECT jd.id_jadwal, jd.id_dokter, d.ndokter, jd.hari, jd.jam " +
                     "FROM jadwal_dokter jd JOIN dokter d ON jd.id_dokter = d.id_dokter " +
                     "ORDER BY jd.hari";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                JadwalDokter j = new JadwalDokter(
                    rs.getInt("id_jadwal"),
                    rs.getInt("id_dokter"),
                    rs.getString("ndokter"),
                    rs.getString("hari"),
                    rs.getString("jam")
                );
                list.add(j);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
