package ss17_io_binary_file.mvc.repository;

import ss17_io_binary_file.mvc.common.ReadToFileBinary;
import ss17_io_binary_file.mvc.common.WriteToFileBinary;
import ss17_io_binary_file.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String PRODUCT_PATH = "src/ss17_io_binary_file/mvc/data/product.dat";
    private List<Product> productList  = new ArrayList<>();
    @Override
    public List<Product> getAll() {
         productList = ReadToFileBinary.readFileBinary(PRODUCT_PATH);
        return productList;
    }

    @Override
    public void add(Product product) {
        productList = getAll();
        productList.add(product);
        WriteToFileBinary.writeFileBinary(PRODUCT_PATH,productList,false);
    }

    @Override
    public List<Product> searchByName(String nameProduct) {
        productList = getAll();
        List<Product> products = new ArrayList<>();
        for (Product product: productList) {
            if(product.getNameProduct().contains(nameProduct)){
                products.add(product);
            }
        }
        return products;
    }
}
