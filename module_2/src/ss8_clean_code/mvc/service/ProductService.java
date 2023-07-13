package ss8_clean_code.mvc.service;

import ss8_clean_code.mvc.repository.IProductRepository;
import ss8_clean_code.mvc.repository.ProductRepository;

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
