package ss8_clean_code.mvc.service;

public interface IProductService {
    // Đọc file
    void read();
    // Xóa File
    void delete();
    // Thêm mới
    void create();
    // Cập nhật , chỉnh sửa
    void update();
    // tìm kiếm
    void searchName();
    void searchID();

}
