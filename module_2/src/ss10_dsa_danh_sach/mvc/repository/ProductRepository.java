package ss10_dsa_danh_sach.mvc.repository;

import ss10_dsa_danh_sach.mvc.common.ReadWriteToFile;
import ss10_dsa_danh_sach.mvc.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    private final String PRODUCT_PATH = "src/ss10_dsa_danh_sach/mvc/data/product.csv";
    private List<Product> products = new ArrayList<>();

    @Override
    public List<Product> display() {
        List<String> stringList = ReadWriteToFile.readToFile(PRODUCT_PATH);
        products.clear();
        String[] info;
        for (String str : stringList) {
            info = str.split(",");
            products.add(new Product(info[0], info[1], Long.parseLong(info[2])));
        }
        return products;
    }

    @Override
    public void add(Product product) {
        List<String> stringList = ReadWriteToFile.readToFile(PRODUCT_PATH);
        stringList.add(product.infoToCSV());
        ReadWriteToFile.writeToFile(PRODUCT_PATH, stringList, true);
    }

    @Override
    public void remove(Product product) {
        products = display();
        products.remove(product);
        List<String> stringList = new ArrayList<>();
        for (Product product1 : products) {
            stringList.add(product1.infoToCSV());
        }
        ReadWriteToFile.writeToFile(PRODUCT_PATH, stringList, false);
    }

    @Override
    public void update(String idProduct, Product product) {
        products = display();
        List<String> stringList = new ArrayList<>();
        for (Product product1: products) {
            if(product1.getIdProduct().equals(idProduct)){
                product1 = product;
            }
            stringList.add(product1.infoToCSV());
        }
        ReadWriteToFile.writeToFile(PRODUCT_PATH,stringList,false);
    }

    @Override
    public Product getByID(String idProduct) {
        products= display();
        for (Product product: products) {
            if(product.getIdProduct().equals(idProduct)){
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> searchNameProduct(String nameProduct) {
        products = display();
        List<Product> productList = new ArrayList<>();
        for (Product product:products) {
            if(product.getNameProduct().contains(nameProduct)){
                productList.add(product);
            }
        }
        return productList;
    }

    @Override
    public Product searchIDProduct(String idProduct) {
        products = display();
        for (Product product: products) {
            if(product.getIdProduct().equals(idProduct)){
                return product;
            }
        }
        return null;
    }
}
