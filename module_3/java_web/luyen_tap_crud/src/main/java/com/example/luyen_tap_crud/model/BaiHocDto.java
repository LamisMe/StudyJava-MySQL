package com.example.luyen_tap_crud.model;

public class BaiHocDto {
    private int maBaiHoc;
    private String tenLoaiBaiHoc;
    private int doKho;
    private int module;
    private String link;

    public BaiHocDto(String tenLoaiBaiHoc, int doKho, int module, String link) {
        this.tenLoaiBaiHoc = tenLoaiBaiHoc;
        this.doKho = doKho;
        this.module = module;
        this.link = link;
    }

    public BaiHocDto(int maBaiHoc, String tenLoaiBaiHoc, int doKho, int module, String link) {
        this.maBaiHoc = maBaiHoc;
        this.tenLoaiBaiHoc = tenLoaiBaiHoc;
        this.doKho = doKho;
        this.module = module;
        this.link = link;
    }

    public int getMaBaiHoc() {
        return maBaiHoc;
    }

    public void setMaBaiHoc(int maBaiHoc) {
        this.maBaiHoc = maBaiHoc;
    }

    public String getTenLoaiBaiHoc() {
        return tenLoaiBaiHoc;
    }

    public void setTenLoaiBaiHoc(String tenLoaiBaiHoc) {
        this.tenLoaiBaiHoc = tenLoaiBaiHoc;
    }

    public int getDoKho() {
        return doKho;
    }

    public void setDoKho(int doKho) {
        this.doKho = doKho;
    }

    public int getModule() {
        return module;
    }

    public void setModule(int module) {
        this.module = module;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
