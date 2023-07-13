package ss10_dsa_danh_sach.arraylist.mvc.view;

import ss10_dsa_danh_sach.arraylist.mvc.controller.CustomerController;

public class Client {
    public static void main(String[] args) {
        CustomerController customerController = new CustomerController();
        customerController.showMenu();
    }
}
