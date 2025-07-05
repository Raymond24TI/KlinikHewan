package com.mycompany.klinik_hewan.model;

public class Dokter {
    private int idDokter;
    private String nama;
    private String username;
    private String password;

    public Dokter(int idDokter, String nama, String username, String password) {
        this.idDokter = idDokter;
        this.nama = nama;
        this.username = username;
        this.password = password;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public String getNama() {
        return nama;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
