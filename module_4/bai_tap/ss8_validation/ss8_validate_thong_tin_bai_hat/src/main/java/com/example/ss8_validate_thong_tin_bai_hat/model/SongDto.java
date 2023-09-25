package com.example.ss8_validate_thong_tin_bai_hat.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class SongDto implements Validator {
    private int id;
    private String nameSong;
    private String artist;
    private String kindOfMusic;

    public SongDto() {
    }

    public SongDto(int id, String nameSong, String artist, String kindOfMusic) {
        this.id = id;
        this.nameSong = nameSong;
        this.artist = artist;
        this.kindOfMusic = kindOfMusic;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        SongDto songDto = (SongDto) target;
        if (songDto.getNameSong().equals("")) {
            errors.rejectValue("nameSong", "null", "Khong duoc de trong");
        } else if (!songDto.getNameSong().matches("^[A-Za-z0-9]+( [A-Za-z0-9])?+$")) {
            errors.rejectValue("nameSong", "null", "Nhap sai dinh dang, khong chua ky tu dac biet");
        } else if (songDto.getNameSong().length() > 800) {
            errors.rejectValue("nameSong", "null", "Khong duoc qua 800 ky tu");
        } else if (songDto.getArtist().equals("")) {
            errors.rejectValue("artist", "null", "Khong duoc de trong");
        } else if (!songDto.getArtist().matches("^[A-Z]([a-z]{0,7})( [A-Z]([a-z]{0,7})){1,7}$")) {
            errors.rejectValue("artist", "null", "Nhap sai dinh dang, chu cai dau phai viet hoa (khong chua ky tu dac biet)");
        } else if (songDto.getArtist().length() > 300) {
            errors.rejectValue("artist", "null", "Khong duoc qua 300 ky tu");
        } else if (songDto.getKindOfMusic().equals("")) {
            errors.rejectValue("kindOfMusic", "null", "Khong duoc de trong");
        } else if (!songDto.getKindOfMusic().matches("^[A-Z]([a-z]{0,7})(,? [A-Za-z]{0,7}){1,7}$")) {
            errors.rejectValue("kindOfMusic", "null", "Nhap sai dinh dang, chu cai dau phai viet hoa (khong chua ky tu dac biet tru dau ',')");
        } else if (songDto.getKindOfMusic().length() > 1000) {
            errors.rejectValue("artist", "null", "Khong duoc qua 300 ky tu");
        }
    }
}
