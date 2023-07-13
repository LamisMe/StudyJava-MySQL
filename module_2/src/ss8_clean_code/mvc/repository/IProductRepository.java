package ss8_clean_code.mvc.repository;

import ss8_clean_code.mvc.model.Product;

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
