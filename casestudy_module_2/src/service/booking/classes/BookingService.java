package service.booking.classes;

import model.booking.Booking;
import model.booking.Contract;
import repository.booking.IBookingRepository;
import repository.booking.IContractRepository;
import repository.booking.classes.BookingRepository;
import repository.booking.classes.ContractRepository;
import service.booking.IBookingService;

import java.util.List;
import java.util.Scanner;

public class BookingService implements IBookingService {
    private final IBookingRepository bookingRepository = new BookingRepository();
    private final IContractRepository contractRepository = new ContractRepository();
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void addBooking() {
        System.out.println("Nhập mã booking");
        String bookingcode = scanner.nextLine();
        System.out.println("Nhập ngày booking");
        String bookingDate = scanner.nextLine();
        System.out.println("Nhập ngày bắt đầu thuêg");
        String rentalStartDate = scanner.nextLine();
        System.out.println("Nhập ngày kết thúc thuê");
        String rentalEndDate = scanner.nextLine();
        System.out.println("Nhập mã khách hàng");
        String customer = scanner.nextLine();
        System.out.println("Nhập dịch vụ");
        String facility = scanner.nextLine();
        Booking booking = new Booking(bookingcode, bookingDate, rentalStartDate, rentalEndDate, customer, facility);
        bookingRepository.add(booking);
    }

    @Override
    public void displayBooking() {
        List<Booking> bookings = bookingRepository.getAll();
        for (Booking booking : bookings) {
            System.out.println(booking);
        }
    }

    @Override
    public void displayContract() {
        List<Contract> contractList = contractRepository.getAll();
        for (Contract contract : contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void creatContract() {
        int someContracts;
        do {
            System.out.println("Nhập số hợp đồng");
            try {
                someContracts = Integer.parseInt(scanner.nextLine());
                if (someContracts > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println("Nhập mã Booking");
        String booking = scanner.nextLine();
        System.out.println("Nhập số tiền cọc trước");
        float advanceDepositAmount = Float.parseFloat(scanner.nextLine());
        System.out.println("Nhập số tiền cọc sau");
        float totalPaymentAmount = Float.parseFloat(scanner.nextLine());
        Contract contract = new Contract(someContracts, booking, advanceDepositAmount, totalPaymentAmount);
        contractRepository.add(contract);
    }

    @Override
    public void editContract() {
        System.out.println("Nhập số hợp đồng cần chỉnh sửa");
        int someContracts;
        do {
            System.out.println("Nhập số hợp đồng");
            try {
                someContracts = Integer.parseInt(scanner.nextLine());
                if (someContracts > 0) {
                    break;
                }
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        Contract contract = contractRepository.getById(someContracts);
        if (contract == null) {
            System.out.println("Không tồn tại hợp đồng");
        } else {
            System.out.println("Nhập mã Booking new");
            String booking = scanner.nextLine();
            contract.setBooking(booking);
            System.out.println("Nhập số tiền cọc trước new");
            float advanceDepositAmount = Float.parseFloat(scanner.nextLine());
            contract.setAdvanceDepositAmount(advanceDepositAmount);
            System.out.println("Nhập số tiền cọc sau new");
            float totalPaymentAmount = Float.parseFloat(scanner.nextLine());
            contract.setTotalPaymentAmount(totalPaymentAmount);
            System.out.println("Bạn có chắc chắn muốn lưu lại thông tin trên không");
            System.out.println("1.Yes");
            System.out.println("2.No");
            String select = scanner.nextLine();
            if (select.equals("1")) {
                contractRepository.edit(someContracts, contract);
            }
        }
    }
}
