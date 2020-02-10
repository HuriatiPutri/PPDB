package com.ta.pendaftaransiswa.model;

public class PesertaModel {
    private String no_pendaftaran;
    private String nama;
    private String nisn;
    private String tmp_lahir;
    private String tgl_lahir;
    private String asal_sekolah;
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
    private String message;
    private int status;
    private String keterangan;

    public PesertaModel() {
    }

    public PesertaModel(String nama, String nisn, String asal_sekolah) {
        this.nama = nama;
        this.nisn = nisn;
        this.asal_sekolah = asal_sekolah;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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

    public String getasal_sekolah() {
        return asal_sekolah;
    }

    public void setasal_sekolah(String asal_sekolah) {
        this.asal_sekolah = asal_sekolah;
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

    public int getStatus() {
        return status;
    }

    public String getAsal_sekolah() {
        return asal_sekolah;
    }

    public void setAsal_sekolah(String asal_sekolah) {
        this.asal_sekolah = asal_sekolah;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
