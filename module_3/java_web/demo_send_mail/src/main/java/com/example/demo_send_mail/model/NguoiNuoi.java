package com.example.demo_send_mail.model;

public class NguoiNuoi {
    private int maNguoiNuoi;
    private String tenNguoiNuoi;
    private int gioiTinh;
    private int maTaiKhoan;
    private int soDienThoai;
    private String email;

    public NguoiNuoi() {
    }
    public NguoiNuoi(String tenNguoiNuoi, int gioiTinh, int soDienThoai, String email) {
        this.tenNguoiNuoi = tenNguoiNuoi;
        this.gioiTinh = gioiTinh;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public NguoiNuoi(String tenNguoiNuoi, int gioiTinh, int maTaiKhoan, int soDienThoai, String email) {
        this.tenNguoiNuoi = tenNguoiNuoi;
        this.gioiTinh = gioiTinh;
        this.maTaiKhoan = maTaiKhoan;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public NguoiNuoi(int maNguoiNuoi, String tenNguoiNuoi, int gioiTinh, int maTaiKhoan, int soDienThoai, String email) {
        this.maNguoiNuoi = maNguoiNuoi;
        this.tenNguoiNuoi = tenNguoiNuoi;
        this.gioiTinh = gioiTinh;
        this.maTaiKhoan = maTaiKhoan;
        this.soDienThoai = soDienThoai;
        this.email = email;
    }

    public int getMaNguoiNuoi() {
        return maNguoiNuoi;
    }

    public void setMaNguoiNuoi(int maNguoiNuoi) {
        this.maNguoiNuoi = maNguoiNuoi;
    }

    public String getTenNguoiNuoi() {
        return tenNguoiNuoi;
    }

    public void setTenNguoiNuoi(String tenNguoiNuoi) {
        this.tenNguoiNuoi = tenNguoiNuoi;
    }

    public int getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(int gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getMaTaiKhoan() {
        return maTaiKhoan;
    }

    public void setMaTaiKhoan(int maTaiKhoan) {
        this.maTaiKhoan = maTaiKhoan;
    }

    public int getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(int soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "NguoiNuoi{" +
                "maNguoiNuoi=" + maNguoiNuoi +
                ", tenNguoiNuoi='" + tenNguoiNuoi + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", maTaiKhoan=" + maTaiKhoan +
                ", soDienThoai=" + soDienThoai +
                ", email='" + email + '\'' +
                '}';
    }
}
