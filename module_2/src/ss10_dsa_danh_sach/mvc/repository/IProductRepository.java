package ss10_dsa_danh_sach.mvc.repository;

import ss10_dsa_danh_sach.mvc.model.Product;

import java.util.List;

public interface IProductRepository
{
    List<Product> display();
    void add(Product product);
    void remove(Product product);
    void update(String idProduct,Product product);
    Product getByID(String idProduct);
    List<Product> searchNameProduct(String nameProduct);
    Product searchIDProduct(String idProduct);
}
