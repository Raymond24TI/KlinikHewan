package model;

public class Pasien {
    private int id;
    private String namaDepan;
    private String namaBelakang;
    private String namaHewan;
    private String kelamin;
    private int umur;
    private String spesies;
    private String kontak;
    private String alamat;
    private String noHp;
    private String email;
    private String keluhan;

    // Constructor
    public Pasien(int id, String namaDepan, String namaBelakang, String namaHewan, String kelamin,
                  int umur, String spesies, String kontak, String alamat, String noHp,
                  String email, String keluhan) {
        this.id = id;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
        this.namaHewan = namaHewan;
        this.kelamin = kelamin;
        this.umur = umur;
        this.spesies = spesies;
        this.kontak = kontak;
        this.alamat = alamat;
        this.noHp = noHp;
        this.email = email;
        this.keluhan = keluhan;
    }

    // Constructor tanpa ID (untuk insert baru)
    public Pasien(String namaDepan, String namaBelakang, String namaHewan, String kelamin,
                  int umur, String spesies, String kontak, String alamat, String noHp,
                  String email, String keluhan) {
        this(0, namaDepan, namaBelakang, namaHewan, kelamin, umur, spesies, kontak, alamat, noHp, email, keluhan);
    }

    // Getter & Setter
    public int getId() {
        return id;
    }

    public String getNamaDepan() {
        return namaDepan;
    }

    public void setNamaDepan(String namaDepan) {
        this.namaDepan = namaDepan;
    }

    public String getNamaBelakang() {
        return namaBelakang;
    }

    public void setNamaBelakang(String namaBelakang) {
        this.namaBelakang = namaBelakang;
    }

    public String getNamaHewan() {
        return namaHewan;
    }

    public void setNamaHewan(String namaHewan) {
        this.namaHewan = namaHewan;
    }

    public String getKelamin() {
        return kelamin;
    }

    public void setKelamin(String kelamin) {
        this.kelamin = kelamin;
    }

    public int getUmur() {
        return umur;
    }

    public void setUmur(int umur) {
        this.umur = umur;
    }

    public String getSpesies() {
        return spesies;
    }

    public void setSpesies(String spesies) {
        this.spesies = spesies;
    }

    public String getKontak() {
        return kontak;
    }

    public void setKontak(String kontak) {
        this.kontak = kontak;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKeluhan() {
        return keluhan;
    }

    public void setKeluhan(String keluhan) {
        this.keluhan = keluhan;
    }

    // Optional: tampilkan info lengkap pasien
    public String getFullInfo() {
        return namaDepan + " " + namaBelakang + " - Hewan: " + namaHewan + " (" + spesies + ")";
    }
}
