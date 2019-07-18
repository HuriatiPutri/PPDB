package com.ta.pendaftaransiswa.model;

public class UserModel {
    private String nisn, nama;

    public UserModel() {
    }

    public UserModel(String nisn, String nama) {
        this.nisn = nisn;
        this.nama = nama;
    }

    public String getNisn() {
        return nisn;
    }

    public void setNisn(String nisn) {
        this.nisn = nisn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }
}
