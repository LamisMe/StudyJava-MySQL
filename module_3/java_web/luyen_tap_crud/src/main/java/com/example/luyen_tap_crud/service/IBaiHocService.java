package com.example.luyen_tap_crud.service;

import com.example.luyen_tap_crud.model.BaiHoc;
import com.example.luyen_tap_crud.model.BaiHocDto;

import java.util.List;

public interface IBaiHocService {
    List<BaiHocDto> hienThiDanhSach();
    void themMoi(BaiHoc baiHoc);
    void xoa(int maBaiHoc);
    BaiHoc chiTietBaiHoc(int maBaiHoc);
    void capNhat(BaiHoc baiHoc);
}
