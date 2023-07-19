package extra_exercises.service;

import extra_exercises.model.Bill;
import extra_exercises.model.ForeignerPeople;
import extra_exercises.model.Person;
import extra_exercises.model.VietNamPeople;
import extra_exercises.repository.*;

import java.util.List;
import java.util.Scanner;

public class BillService implements IBillService {
    private final Scanner scanner = new Scanner(System.in);
    private final IBillRepository iBillRepository = new BillRepository();
    private final IPersonService foreignerPeopleService = new ForeignerPeopleService();
    private final IPersonService vietNamPeopleService = new VietNamPeopleService();
    private final IPersonRepository<ForeignerPeople> foreignerPeopleIPersonRepository = new ForeignerPeopleRepository();
    private final IPersonRepository<VietNamPeople> personRepository = new VietNamPeopleRepository();

    @Override
    public void add() {
        System.out.println("Nhập mã hóa đơn");
        String codeBill = scanner.nextLine();
        System.out.println("Chọn khách hàng đăng ký");
        System.out.println("1.Khách hàng Việt Nam");
        System.out.println("2.Khách hàng Nước Ngoài");
        String select = scanner.nextLine();
        String codePerson = "";
        switch (select) {
            case "1":
                do {
                    vietNamPeopleService.read();
                    System.out.println("Nhập mã khách hàng đăng ký");
                    String codePerson1 = scanner.nextLine();
                    Person person1 = personRepository.getByID(codePerson1);
                    if (person1 == null) {
                        System.out.println("Không tìm thấy khách hàng");
                    } else {
                        codePerson = codePerson1;
                        break;
                    }
                } while (true);
                break;
            case "2":
                do {
                    foreignerPeopleService.read();
                    System.out.println("Nhập mã khách hàng đăng ký");
                    String codePerson2 = scanner.nextLine();
                    Person person2 = foreignerPeopleIPersonRepository.getByID(codePerson2);
                    if (person2 == null) {
                        System.out.println("Không tìm thấy khách hàng");
                    } else {
                        codePerson = codePerson2;
                        break;
                    }
                } while (true);
                break;
        }
        System.out.println("Nhập ngày ra hóa đơn");
        String dateOfBill = scanner.nextLine();
        System.out.println("Nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập đơn giá");
        long unitPrice = Long.parseLong(scanner.nextLine());
        long intoMoney;
        if (select.equals("1")) {
            if (personRepository.getByID(codePerson).getConsumptionNorms() - quantity < 0) {
                intoMoney = (long) (personRepository.getByID(codePerson).getConsumptionNorms() * unitPrice + quantity * unitPrice * 2.5);
            } else {
                intoMoney = quantity * unitPrice;
            }
        } else {
            intoMoney = quantity * unitPrice;
        }
        Bill bill = new Bill(codeBill, codePerson, dateOfBill, quantity, unitPrice, intoMoney);
        iBillRepository.addBill(bill);
    }

    @Override
    public void update() {
        System.out.println("Nhập mã hóa đơn cần chỉnh sửa");
        String codeBill = scanner.nextLine();
        Bill bill = iBillRepository.getById(codeBill);
        do {
            if (bill == null) {
                System.out.println("Mã hóa đơn không tồn tại");
            } else {
                System.out.println("Chọn thông tin cần sửa");
                System.out.println("1.Khach Hàng");
                System.out.println("2.Ngày xuất hóa đơn");
                System.out.println("3.Số lượng");
                System.out.println("4.Đơn giá");
                System.out.println("0.Lưu thông tin");
                String select = scanner.nextLine();
                String select1;
                switch (select) {
                    case "1":
                        System.out.println("Chọn khách hàng đăng ký");
                        System.out.println("1.Khách hàng Việt Nam");
                        System.out.println("2.Khách hàng Nước Ngoài");
                         select1 = scanner.nextLine();
                        String codePerson = "";
                        switch (select1) {
                            case "1":
                                do {
                                    vietNamPeopleService.read();
                                    System.out.println("Nhập mã khách hàng đăng ký");
                                    String codePerson1 = scanner.nextLine();
                                    Person person1 = personRepository.getByID(codePerson1);
                                    if (person1 == null) {
                                        System.out.println("Không tìm thấy khách hàng");
                                    } else {
                                        codePerson = codePerson1;
                                        break;
                                    }
                                } while (true);
                                break;
                            case "2":
                                do {
                                    foreignerPeopleService.read();
                                    System.out.println("Nhập mã khách hàng đăng ký");
                                    String codePerson2 = scanner.nextLine();
                                    Person person2 = foreignerPeopleIPersonRepository.getByID(codePerson2);
                                    if (person2 == null) {
                                        System.out.println("Không tìm thấy khách hàng");
                                    } else {
                                        codePerson = codePerson2;
                                        break;
                                    }
                                } while (true);
                                break;
                        }
                        bill.setPerson(codePerson);
                        break;
                    case "2":
                        System.out.println("Nhập ngày ra hóa đơn");
                        String dateOfBill = scanner.nextLine();
                        bill.setInvoiceDate(dateOfBill);
                        break;
                    case "3":
                        System.out.println("Nhập số lượng");
                        int quantity = Integer.parseInt(scanner.nextLine());
                        bill.setQuantity(quantity);
                        break;
                    case "4":
                        System.out.println("Nhập đơn giá");
                        long unitPrice = Long.parseLong(scanner.nextLine());
                        bill.setUnitPrice(unitPrice);
                        break;
                    case "0":
                        iBillRepository.update(codeBill, bill);
                        return;
                }
            }
        } while (true);
    }

    @Override
    public void display() {
        List<Bill> billList = iBillRepository.getAllBill();
        for (Bill bill : billList) {
            System.out.println(bill);
        }
    }
}
