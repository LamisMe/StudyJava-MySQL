package com.example.luyen_tap_crud.service;

import com.example.luyen_tap_crud.model.BaiHoc;
import com.example.luyen_tap_crud.model.BaiHocDto;
import com.example.luyen_tap_crud.repository.BaiHocRepository;
import com.example.luyen_tap_crud.repository.IBaiHocRepository;

import java.util.List;

public class BaiHocService implements IBaiHocService{
    private IBaiHocRepository baiHocRepository = new BaiHocRepository();
    @Override
    public List<BaiHocDto> hienThiDanhSach() {
        return baiHocRepository.hienThiDanhSach();
    }

    @Override
    public void themMoi(BaiHoc baiHoc) {
        baiHocRepository.themMoi(baiHoc);
    }

    @Override
    public void xoa(int maBaiHoc) {
        baiHocRepository.xoa(maBaiHoc);
    }

    @Override
    public BaiHoc chiTietBaiHoc(int maBaiHoc) {
        return baiHocRepository.baiHoc(maBaiHoc);
    }

    @Override
    public void capNhat(BaiHoc baiHoc) {
        baiHocRepository.capNhat(baiHoc);
    }


}
