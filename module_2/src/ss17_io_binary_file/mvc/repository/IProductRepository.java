package ss17_io_binary_file.mvc.repository;

import ss17_io_binary_file.mvc.model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void add(Product product);
    List<Product> searchByName(String nameProduct);
}
