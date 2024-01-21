package com.example.luyen_tap_crud.repository;

import com.example.luyen_tap_crud.model.BaiHoc;
import com.example.luyen_tap_crud.model.BaiHocDto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BaiHocRepository implements IBaiHocRepository {
    private static final String TRUY_VAN_HIEN_THI = "select bh.ma_bai_hoc,lbh.ten_loai_bai_hoc,bh.do_kho,bh.module,bh.link\n" +
            "from bai_hoc bh\n" +
            "join loai_bai_hoc lbh on lbh.ma_loai_bai_hoc = bh.ma_loai_bai_hoc\n" +
            "where trang_thai_xoa  = 0;  ";
    private static final String THEM_MOI = "insert into bai_hoc(ma_loai_bai_hoc,do_kho,module,link) values(?,?,?,?);";

    private  static final String XOA_BAI_HOC ="update bai_hoc set trang_thai_xoa = 1 where ma_bai_hoc = ?;";

    private static final String CAP_NHAT = "update bai_hoc set ma_loai_bai_hoc = ? ,do_kho = ?, module = ?,link = ? where ma_bai_hoc = ?;";
    private static final String CHI_TIET_BAI_HOC = "select bai_hoc.ma_loai_bai_hoc,bai_hoc.do_kho,bai_hoc.module,bai_hoc.link from bai_hoc where ma_bai_hoc = ? and trang_thai_xoa = 0;";
    @Override
    public List<BaiHocDto> hienThiDanhSach() {
        Connection connection = BaseRepository.getConnection();
        List<BaiHocDto> baiHocDto = new ArrayList<>();
        try{
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(TRUY_VAN_HIEN_THI);
            while (resultSet.next()){
              int maBaiHoc = resultSet.getInt("ma_bai_hoc");
              String tenBaiHoc = resultSet.getString("ten_loai_bai_hoc");
              int doKho = resultSet.getInt("do_kho");
              int module = resultSet.getInt("module");
              String link = resultSet.getString("link");
              BaiHocDto baiHoc = new BaiHocDto(maBaiHoc,tenBaiHoc,doKho,module,link);
              baiHocDto.add(baiHoc);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return baiHocDto;
    }

    @Override
    public void themMoi(BaiHoc baiHoc) {
        Connection connection = BaseRepository.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(THEM_MOI);
            preparedStatement.setInt(1,baiHoc.getMaLoaiBaiHoc());
            preparedStatement.setInt(2,baiHoc.getDoKho());
            preparedStatement.setInt(3,baiHoc.getModule());
            preparedStatement.setString(4,baiHoc.getLink());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void xoa(int mabaiHoc) {
        Connection connection = BaseRepository.getConnection();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(XOA_BAI_HOC);
            preparedStatement.setInt(1,mabaiHoc);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void capNhat(BaiHoc baiHoc) {
        Connection connection = BaseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(CAP_NHAT);
            preparedStatement.setInt(1,baiHoc.getMaLoaiBaiHoc());
            preparedStatement.setInt(2,baiHoc.getDoKho());
            preparedStatement.setInt(3,baiHoc.getModule());
            preparedStatement.setString(4,baiHoc.getLink());
            preparedStatement.setInt(5,baiHoc.getMaBaiHoc());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public BaiHoc baiHoc(int maBaiHoc) {
        Connection connection  = BaseRepository.getConnection();
        BaiHoc baiHoc=null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(CHI_TIET_BAI_HOC);
            preparedStatement.setInt(1,maBaiHoc);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int maLoaiBaiHoc = resultSet.getInt("ma_loai_bai_hoc");
                int doKho = resultSet.getInt("do_kho");
                int module = resultSet.getInt("module");
                String link = resultSet.getString("link");
                 baiHoc =new  BaiHoc(maBaiHoc,maLoaiBaiHoc,doKho,module,link);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return baiHoc;
    }
}
