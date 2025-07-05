package model;

public class JadwalDokter {
    private int idJadwal;
    private int idDokter;
    private String namaDokter;
    private String hari;
    private String jam;

    public JadwalDokter(int idJadwal, int idDokter, String namaDokter, String hari, String jam) {
        this.idJadwal = idJadwal;
        this.idDokter = idDokter;
        this.namaDokter = namaDokter;
        this.hari = hari;
        this.jam = jam;
    }

    public int getIdJadwal() {
        return idJadwal;
    }

    public int getIdDokter() {
        return idDokter;
    }

    public String getNamaDokter() {
        return namaDokter;
    }

    public String getHari() {
        return hari;
    }

    public String getJam() {
        return jam;
    }
}
