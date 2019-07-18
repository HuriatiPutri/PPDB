package com.ta.pendaftaransiswa.model;

public class PesertaModel {
    private String nama;
    private String nisn;
    private String tmp_lahir;
    private String tgl_lahir;
    private String sekolah_asal;
    private String alamat;
    private String jk;
    private String n_mtk;
    private String n_bindo;
    private String n_bing;
    private String avg;
    private String tahun_lulus;
    private String telepon;



    private String nm_ayah;
    private String nm_ibu;
    private String program ;
    private String error;

    public PesertaModel() {
    }

    public PesertaModel(String nama, String nisn, String sekolah_asal) {
        this.nama = nama;
        this.nisn = nisn;
        this.sekolah_asal = sekolah_asal;
    }

    public PesertaModel(String nama, String nisn, String tmp_lahir, String tgl_lahir, String sekolah_asal, String alamat, String jk, String n_mtk, String n_bindo, String n_bing, String avg, String tahun_lulus, String nm_ayah, String nm_ibu, String program) {
        this.nama = nama;
        this.nisn = nisn;
        this.tmp_lahir = tmp_lahir;
        this.tgl_lahir = tgl_lahir;
        this.sekolah_asal = sekolah_asal;
        this.alamat = alamat;
        this.jk = jk;
        this.n_mtk = n_mtk;
        this.n_bindo = n_bindo;
        this.n_bing = n_bing;
        this.avg = avg;
        this.tahun_lulus = tahun_lulus;
        this.nm_ayah = nm_ayah;
        this.nm_ibu = nm_ibu;
        this.program = program;
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

    public String getSekolah_asal() {
        return sekolah_asal;
    }

    public void setSekolah_asal(String sekolah_asal) {
        this.sekolah_asal = sekolah_asal;
    }

    public String getTmp_lahir() {
        return tmp_lahir;
    }

    public void setTmp_lahir(String tmp_lahir) {
        this.tmp_lahir = tmp_lahir;
    }

    public String getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(String tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public String getsekolah_asal() {
        return sekolah_asal;
    }

    public void setsekolah_asal(String sekolah_asal) {
        this.sekolah_asal = sekolah_asal;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getJk() {
        return jk;
    }

    public void setJk(String jk) {
        this.jk = jk;
    }

    public String getN_mtk() {
        return n_mtk;
    }

    public void setN_mtk(String n_mtk) {
        this.n_mtk = n_mtk;
    }

    public String getN_bindo() {
        return n_bindo;
    }

    public void setN_bindo(String n_bindo) {
        this.n_bindo = n_bindo;
    }

    public String getN_bing() {
        return n_bing;
    }

    public void setN_bing(String n_bing) {
        this.n_bing = n_bing;
    }

    public String getAvg() {
        return avg;
    }

    public void setAvg(String avg) {
        this.avg = avg;
    }

    public String getTahun_lulus() {
        return tahun_lulus;
    }

    public void setTahun_lulus(String tahun_lulus) {
        this.tahun_lulus = tahun_lulus;
    }

    public String getNm_ayah() {
        return nm_ayah;
    }

    public void setNm_ayah(String nm_ayah) {
        this.nm_ayah = nm_ayah;
    }

    public String getNm_ibu() {
        return nm_ibu;
    }

    public void setNm_ibu(String nm_ibu) {
        this.nm_ibu = nm_ibu;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getTelepon() {
        return telepon;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }
    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
