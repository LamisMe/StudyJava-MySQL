package ss17_io_binary_file.mvc.service;

import ss17_io_binary_file.mvc.model.Product;
import ss17_io_binary_file.mvc.repository.IProductRepository;
import ss17_io_binary_file.mvc.repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService{
    private IProductRepository productRepository = new ProductRepository();
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void display() {
        List<Product> productList = productRepository.getAll();
        for (Product product: productList) {
            System.out.println(product);
        }
    }

    @Override
    public void add() {
        System.out.println("Nhập mã sản phẩm");
        String codeProduct = scanner.nextLine();
        System.out.println("Nhập tên sản phẩm");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm");
        long price = Long.parseLong(scanner.nextLine());
        System.out.println("Nhập hãng sản xuất");
        String manufacturer = scanner.nextLine();
        System.out.println("Nhập mô tả");
        String describe = scanner.nextLine();
        Product product = new Product(codeProduct, nameProduct, price, manufacturer, describe);
        productRepository.add(product);
        System.out.println("Thêm thành công");
    }

    @Override
    public void search() {
        System.out.println("Nhập tên sản phẩm bạn muốn tìm kiếm");
        String nameProduct = scanner.nextLine();
        List<Product> productList = productRepository.searchByName(nameProduct);
        if(productList.isEmpty()){
            System.out.println("Không có tên sản phẩm trong hệ thống ");
        }else {
            for (Product product:productList) {
                System.out.println(product);
            }
        }
    }
}
