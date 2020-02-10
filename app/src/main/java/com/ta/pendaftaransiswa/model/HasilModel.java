package com.ta.pendaftaransiswa.model;

public class HasilModel {
    private String no_pendaftaran,nama, nisn, keterangan, status;

    public HasilModel(String no_pendaftaran, String nama, String nisn, String keterangan, String status) {
        this.no_pendaftaran = no_pendaftaran;
        this.nama = nama;
        this.nisn = nisn;
        this.keterangan = keterangan;
        this.status = status;
    }

    public HasilModel() {
    }

    public String getNo_pendaftaran() {
        return no_pendaftaran;
    }

    public void setNo_pendaftaran(String no_pendaftaran) {
        this.no_pendaftaran = no_pendaftaran;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
