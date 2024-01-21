package com.example.luyen_tap_crud.repository;

import com.example.luyen_tap_crud.model.BaiHoc;
import com.example.luyen_tap_crud.model.BaiHocDto;

import java.util.List;

public interface IBaiHocRepository {
    List<BaiHocDto> hienThiDanhSach();
    void themMoi(BaiHoc baiHoc);
    void xoa(int baiHoc);
    void capNhat(BaiHoc baiHoc);
    BaiHoc baiHoc(int maBaiHoc);
}
