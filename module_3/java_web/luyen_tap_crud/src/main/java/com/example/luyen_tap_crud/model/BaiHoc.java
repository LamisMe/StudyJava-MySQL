package com.example.luyen_tap_crud.model;

public class BaiHoc {
    private int maBaiHoc ;
    private int maLoaiBaiHoc;
    private int doKho;
    private int module;
    private String link;

    public BaiHoc(int maLoaiBaiHoc, int doKho, int module, String link) {
        this.maLoaiBaiHoc = maLoaiBaiHoc;
        this.doKho = doKho;
        this.module = module;
        this.link = link;
    }

    public BaiHoc(int maBaiHoc, int maLoaiBaiHoc, int doKho, int module, String link) {
        this.maBaiHoc = maBaiHoc;
        this.maLoaiBaiHoc = maLoaiBaiHoc;
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

    public int getMaLoaiBaiHoc() {
        return maLoaiBaiHoc;
    }

    public void setMaLoaiBaiHoc(int maLoaiBaiHoc) {
        this.maLoaiBaiHoc = maLoaiBaiHoc;
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
