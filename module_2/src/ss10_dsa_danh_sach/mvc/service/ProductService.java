package ss10_dsa_danh_sach.mvc.service;

import ss10_dsa_danh_sach.mvc.repository.IProductRepository;
import ss10_dsa_danh_sach.mvc.repository.ProductRepository;

import java.util.Scanner;

public class ProductService implements IProductService{
    private final IProductRepository productRepository = new ProductRepository();
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void read() {

    }

    @Override
    public void delete() {

    }

    @Override
    public void create() {

    }

    @Override
    public void update() {

    }

    @Override
    public void searchName() {
        
    }

    @Override
    public void searchID() {

    }
}
