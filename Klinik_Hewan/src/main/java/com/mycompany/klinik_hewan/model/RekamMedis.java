package com.mycompany.klinik_hewan.model;

import java.sql.Timestamp;

public class RekamMedis {
    private int idRekam;
    private int idPasien;
    private String keluhan;
    private String diagnosa;
    private String obat;
    private String takaran;
    private String status; // "baru", "ditangani", "selesai"
    private Timestamp tanggal;

    // Constructor lengkap
    public RekamMedis(int idRekam, int idPasien, String keluhan, String diagnosa,
                      String obat, String takaran, String status, Timestamp tanggal) {
        this.idRekam = idRekam;
        this.idPasien = idPasien;
        this.keluhan = keluhan;
        this.diagnosa = diagnosa;
        this.obat = obat;
        this.takaran = takaran;
        this.status = status;
        this.tanggal = tanggal;
    }

    // Constructor awal (untuk input keluhan baru dari staff)
    public RekamMedis(int idPasien, String keluhan) {
        this.idPasien = idPasien;
        this.keluhan = keluhan;
        this.status = "baru";
    }

    // Getter dan Setter
    public int getIdRekam() {
        return idRekam;
    }

    public void setIdRekam(int idRekam) {
        this.idRekam = idRekam;
    }

    public int getIdPasien() {
        return idPasien;
    }

    public void setIdPasien(int idPasien) {
        this.idPasien = idPasien;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    public String getDiagnosa() {
        return diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        this.diagnosa = diagnosa;
    }

    public String getObat() {
        return obat;
    }

    public void setObat(String obat) {
        this.obat = obat;
    }

    public String getTakaran() {
        return takaran;
    }

    public void setTakaran(String takaran) {
        this.takaran = takaran;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getTanggal() {
        return tanggal;
    }

    public void setTanggal(Timestamp tanggal) {
        this.tanggal = tanggal;
    }
}
