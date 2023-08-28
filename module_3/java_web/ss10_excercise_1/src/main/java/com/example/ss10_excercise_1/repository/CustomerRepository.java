package com.example.ss10_excercise_1.repository;

import com.example.ss10_excercise_1.model.Customer;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class CustomerRepository implements ICustomerRepository{
    private static final Map<Integer,Customer> customerMap = new LinkedHashMap<>();
    static {
        customerMap.put(1,new Customer("Mai Văn Hoàn","1983-08-20","Hà Nội","https://pbs.twimg.com/media/Fn1HbGNWIAAFgZr.jpg:large"));
        customerMap.put(2,new Customer("Nguyễn Văn Nam","1983-08-21","Bắc Giang","https://www.oncenoticias.hn/wp-content/uploads/2023/06/alexis-mac-allister-2-990x557.jpg.webp"));
        customerMap.put(3,new Customer("Nguyễn Thái Hòa","1983-08-22","Nam Định","https://pbs.twimg.com/media/E7Y_mgUX0AEnng9.jpg"));
        customerMap.put(4,new Customer("Trần Đăng Khoa","1983-08-17","Hà Tây","https://wallpapers.com/images/hd/juventus-paulo-exequiel-dybala-la-joya-gyeuwkxru8ijv8ix.jpg"));
        customerMap.put(5,new Customer("Nguyễn Đình Thi","1983-08-19","Hà Nội","https://static-images.vnncdn.net/files/publish/2023/8/19/thanh-nha-1-161.jpg"));
    }
    @Override
    public Map<Integer,Customer> getAllCustomer() {
        return customerMap;
    }
}
