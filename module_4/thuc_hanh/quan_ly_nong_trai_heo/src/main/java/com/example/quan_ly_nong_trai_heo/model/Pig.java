package com.example.quan_ly_nong_trai_heo.model;

import javax.persistence.*;

@Entity
@Table(name = "pigs")
public class Pig {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String pigId;
    @Column(columnDefinition = "date")
    private String barnEntryTime;
    private double weightBarn;
    @Column(columnDefinition = "date")
    private String releaseTime;
    private double weightRelease;
    @Column(name = "is_deleted", columnDefinition = "int(1) default 0")
    private boolean isDeleted;
    @Column(name = "status", columnDefinition = "int(1) default 0")
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    Location location;

    public Pig() {
    }

    /**
     * @author: Lam
     * @date: 11/10/2023
     * @param id mã entity
     * @param pigId mã số heo
     * @param barnEntryTime thời gian nhập chuồng
     * @param weightBarn trọng lượng khi nhập chuồng
     * @param releaseTime thời gian xuất chuồng
     * @param weightRelease trọng lượng khi xuất chuồng(nếu chưa bán bằng trọng lượng khi nhập chuồng)
     * @param isDeleted trạng thái heo đã xóa hay chưa
     * @param status trạng thái đã bán hay chưa
     * @param location Xuất xứ
     */
    public Pig(int id, String pigId, String barnEntryTime, double weightBarn, String releaseTime, double weightRelease, boolean isDeleted, boolean status, Location location) {
        this.id = id;
        this.pigId = pigId;
        this.barnEntryTime = barnEntryTime;
        this.weightBarn = weightBarn;
        this.releaseTime = releaseTime;
        this.weightRelease = weightRelease;
        this.isDeleted = isDeleted;
        this.status = status;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPigId() {
        return pigId;
    }

    public void setPigId(String pigId) {
        this.pigId = pigId;
    }

    public String getBarnEntryTime() {
        return barnEntryTime;
    }

    public void setBarnEntryTime(String barnEntryTime) {
        this.barnEntryTime = barnEntryTime;
    }

    public double getWeightBarn() {
        return weightBarn;
    }

    public void setWeightBarn(double weightBarn) {
        this.weightBarn = weightBarn;
    }

    public String getReleaseTime() {
        return releaseTime;
    }

    public void setReleaseTime(String releaseTime) {
        this.releaseTime = releaseTime;
    }

    public double getWeightRelease() {
        return weightRelease;
    }

    public void setWeightRelease(double weightRelease) {
        this.weightRelease = weightRelease;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
