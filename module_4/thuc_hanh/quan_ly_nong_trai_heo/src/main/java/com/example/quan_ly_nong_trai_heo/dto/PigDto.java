package com.example.quan_ly_nong_trai_heo.dto;

import com.example.quan_ly_nong_trai_heo.model.Location;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;


public class PigDto implements Validator {
    private Integer id;
    private String pigId;
    private String barnEntryTime;
    private double weightBarn;
    private String releaseTime;
    private double weightRelease;
    private boolean status;
    Location location;

    public PigDto() {
    }

    public PigDto(int id, String pigId, String barnEntryTime, double weightBarn, String releaseTime, double weightRelease, boolean status, Location location) {
        this.id = id;
        this.pigId = pigId;
        this.barnEntryTime = barnEntryTime;
        this.weightBarn = weightBarn;
        this.releaseTime = releaseTime;
        this.weightRelease = weightRelease;
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        PigDto pigDto = (PigDto) target;
        if (pigDto.getWeightBarn() < 10) {
            errors.rejectValue("weightBarn", null,"Trọng lượng phải lớn hơn 10");
        } else if (pigDto.getWeightBarn() > 500) {
            errors.rejectValue("weightBarn",null, "Trọng lượng phải lớn hơn 10");
        } else if (pigDto.getWeightRelease() < 10) {
            errors.rejectValue("weightRelease", null,"Trọng lượng phải lớn hơn 10");
        } else if (pigDto.getWeightRelease() > 500) {
            errors.rejectValue("weightRelease",null, "Không con heo nào nặng như này cả");
        } else if (pigDto.getPigId().length() >100) {
            errors.rejectValue("pigId",null,"Không nhập quá 100 ký tự");
        }else if (pigDto.getPigId().matches("^MH-/d{4}$")) {
            errors.rejectValue("pigId",null,"Nhập sai định dạng (MH-XXXX)");
        }
    }
}
