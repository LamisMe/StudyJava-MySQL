package service.facility.classes;

import model.facility.Facility;
import model.facility.sub_class.House;
import model.facility.sub_class.Room;
import model.facility.sub_class.Villa;
import repository.facility.IFacilityRepository;
import repository.facility.classes.FacilityRepository;
import service.facility.IFacilityService;
import utils.ValidateFacility;

import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

public class FacilityService implements IFacilityService {
    private final Scanner scanner = new Scanner(System.in);
    private final IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void display() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.getAll();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Chưa có dữ liệu trong hệ thống");
        }
        for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
            System.out.println(entry.getKey() + ", số lần sử dụng: " + entry.getValue());
        }
    }

    @Override
    public void add() {
        do {
            System.out.println("Chọn cơ sở bạn muốn thêm");
            System.out.println("1.Thêm Villa");
            System.out.println("2.Thêm House");
            System.out.println("3.Thêm Room");
            System.out.println("0.Quay trở lại menu");
            String select = scanner.nextLine();
            switch (select) {
                case "1":
                    addFacility(new Villa());
                    break;
                case "2":
                    addFacility(new House());
                    break;
                case "3":
                    addFacility(new Room());
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Nhập sai nhập lại");
                    break;
            }
        } while (true);
    }

    @Override
    public void displayAllMaintenance() {
        Map<Facility, Integer> facilityIntegerMap = facilityRepository.getAllMaintenance();
        if (facilityIntegerMap.isEmpty()) {
            System.out.println("Không có cơ sở nào cần bảo trì ở thời điểm hiện tại");
        } else {
            for (Map.Entry<Facility, Integer> entry : facilityIntegerMap.entrySet()) {
                System.out.println(entry.getKey() + ", số lần sử dụng: " + entry.getValue());
            }
        }
    }

    @Override
    public void remove() {
        display();
        System.out.println("Nhập mã cơ sở mà bạn muốn xóa ");
        String codeFacility = scanner.nextLine();
        Facility facility = facilityRepository.getByID(codeFacility);
        if (facility == null) {
            System.out.println("Không tồn tại mã cơ sở trong hệ thống");
        } else {
            System.out.println("Bạn có chắc chắn muốn xóa cơ sở " + facility.getNameService());
            System.out.println("1.Yes");
            System.out.println("2.No");
            String select = scanner.nextLine();
            if (select.equals("1")) {
                facilityRepository.remove(facility);
            }
        }
    }

    public void addFacility(Facility facility) {
        /*
          -Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường
          -Diện tích sử dụng và diện tích hồ bơi phải là số thực lớn hơn 30m2
          -Chi phí thuê phải là số dương
          -Số lượng người tối đa phải >0 và nhỏ hơn <20
          -Số tầng phải là số nguyên dương.
          - Kiểu thuê, Tiêu chuẩn phòng chuẩn hóa dữ liệu giống tên dịch vụ
         */
        if (Objects.equals(facility, new Villa())) {
            String codeFacility;
            do {
                System.out.println("Nhập mã dịch vụ(theo định dạng SVVL-YYYY,YYYY là các số tư 0-9)");
                codeFacility = scanner.nextLine();
            } while (!ValidateFacility.checkValidateCodeVilla(codeFacility));

            String nameService;
            do {
                System.out.println("Nhập tên dịch vụ (Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường)");
                nameService = scanner.nextLine();
            } while (!ValidateFacility.checkValidateName(nameService));

            float usableArea;
            do {
                System.out.println("Nhập Diện tích sử dụng (là số thực lớn hơn 30m2)");
                try {
                    usableArea = Float.parseFloat(scanner.nextLine());
                    if (usableArea > 30) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            float rentalCost;
            do {
                System.out.println("Nhập Chi phí thuê (phải là số dương)");
                try {
                    rentalCost = Float.parseFloat(scanner.nextLine());
                    if (rentalCost > 0) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            int maximumNumberOfPeople;
            do {
                System.out.println("Nhập Số lượng người tối đa phải >0 và nhỏ hơn <20");
                try {
                    maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
                    if (maximumNumberOfPeople > 0 && maximumNumberOfPeople < 20) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            String typeRental;
            AD:
            do {
                System.out.println("Chọn kiểu thuê");
                System.out.println("1.Giờ");
                System.out.println("2.Ngày");
                System.out.println("3.Tuần");
                System.out.println("4.Tháng");
                String select = scanner.nextLine();
                switch (select) {
                    case "1":
                        typeRental = "Giờ";
                        break AD;
                    case "2":
                        typeRental = "Ngày";
                        break AD;
                    case "3":
                        typeRental = "Tuần";
                        break AD;
                    case "4":
                        typeRental = "Tháng";
                        break AD;
                    default:
                        System.out.println("Nhập sai nhập lại");
                        break;
                }
            } while (true);

            String roomStandard;
            AC:
            do {
                System.out.println("Chọn tiêu chuẩn phòng");
                System.out.println("1.Thường");
                System.out.println("2.Vip");
                System.out.println("3.President");
                String select = scanner.nextLine();
                switch (select) {
                    case "1":
                        roomStandard = "Thường";
                        break AC;
                    case "2":
                        roomStandard = "Vip";
                        break AC;
                    case "3":
                        roomStandard = "President";
                        break AC;
                    default:
                        System.out.println("Nhập sai nhập lại");
                        break;
                }
            } while (true);

            float poolArea;
            do {
                System.out.println("Nhập Diện tích hồ bơi (là số thực lớn hơn 30m2)");
                try {
                    poolArea = Float.parseFloat(scanner.nextLine());
                    if (poolArea > 30) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            int floorsNumber;
            do {
                System.out.println("Nhập Số tầng (phải là số dương)");
                try {
                    floorsNumber = Integer.parseInt(scanner.nextLine());
                    if (floorsNumber > 0) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            Villa villa = new Villa(codeFacility, nameService, usableArea, rentalCost, maximumNumberOfPeople, typeRental, roomStandard, poolArea, floorsNumber);
            facilityRepository.add(villa);

        } else if (Objects.equals(facility, new House())) {
            String codeFacility;
            do {
                System.out.println("Nhập mã dịch vụ(theo định dạng SVHO-YYYY,YYYY là các số tư 0-9)");
                codeFacility = scanner.nextLine();
            } while (!ValidateFacility.checkValidateCodeHouse(codeFacility));

            String nameService;
            do {
                System.out.println("Nhập tên dịch vụ (Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường)");
                nameService = scanner.nextLine();
            } while (!ValidateFacility.checkValidateName(nameService));

            float usableArea;
            do {
                System.out.println("Diện tích sử dụng (là số thực lớn hơn 30m2)");
                try {
                    usableArea = Float.parseFloat(scanner.nextLine());
                    if (usableArea > 30) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            float rentalCost;
            do {
                System.out.println("Nhập Chi phí thuê (phải là số dương)");
                try {
                    rentalCost = Float.parseFloat(scanner.nextLine());
                    if (rentalCost > 0) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            int maximumNumberOfPeople;
            do {
                System.out.println("Nhập Số lượng người tối đa phải >0 và nhỏ hơn <20");
                try {
                    maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
                    if (maximumNumberOfPeople > 0 && maximumNumberOfPeople < 20) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            String typeRental;
            AD:
            do {
                System.out.println("Chọn kiểu thuê");
                System.out.println("1.Giờ");
                System.out.println("2.Ngày");
                System.out.println("3.Tuần");
                System.out.println("4.Tháng");
                String select = scanner.nextLine();
                switch (select) {
                    case "1":
                        typeRental = "Giờ";
                        break AD;
                    case "2":
                        typeRental = "Ngày";
                        break AD;
                    case "3":
                        typeRental = "Tuần";
                        break AD;
                    case "4":
                        typeRental = "Tháng";
                        break AD;
                    default:
                        System.out.println("Nhập sai nhập lại");
                        break;
                }
            } while (true);

            String roomStandard;
            AC:
            do {
                System.out.println("Chọn tiêu chuẩn phòng");
                System.out.println("1.Thường");
                System.out.println("2.Vip");
                System.out.println("3.President");
                String select = scanner.nextLine();
                switch (select) {
                    case "1":
                        roomStandard = "Thường";
                        break AC;
                    case "2":
                        roomStandard = "Vip";
                        break AC;
                    case "3":
                        roomStandard = "President";
                        break AC;
                    default:
                        System.out.println("Nhập sai nhập lại");
                        break;
                }
            } while (true);

            int floorsNumber;
            do {
                System.out.println("Nhập Số tầng (phải là số dương)");
                try {
                    floorsNumber = Integer.parseInt(scanner.nextLine());
                    if (floorsNumber > 0) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            House house = new House(codeFacility, nameService, usableArea, rentalCost, maximumNumberOfPeople, typeRental, roomStandard, floorsNumber);
            facilityRepository.add(house);

        } else {
            String codeFacility;
            do {
                System.out.println("Nhập mã dịch vụ(theo định dạng SVRO-YYYY,YYYY là các số tư 0-9)");
                codeFacility = scanner.nextLine();
            } while (!ValidateFacility.checkValidateCodeRoom(codeFacility));

            String nameService;
            do {
                System.out.println("Nhập tên dịch vụ (Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường)");
                nameService = scanner.nextLine();
            } while (!ValidateFacility.checkValidateName(nameService));

            float usableArea;
            do {
                System.out.println("Diện tích sử dụng (là số thực lớn hơn 30m2)");
                try {
                    usableArea = Float.parseFloat(scanner.nextLine());
                    if (usableArea > 30) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            float rentalCost;
            do {
                System.out.println("Nhập Chi phí thuê (phải là số dương)");
                try {
                    rentalCost = Float.parseFloat(scanner.nextLine());
                    if (rentalCost > 0) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            int maximumNumberOfPeople;
            do {
                System.out.println("Nhập Số lượng người tối đa phải >0 và nhỏ hơn <20");
                try {
                    maximumNumberOfPeople = Integer.parseInt(scanner.nextLine());
                    if (maximumNumberOfPeople > 0 && maximumNumberOfPeople < 20) {
                        break;
                    }
                } catch (NumberFormatException numberFormatException) {
                    System.out.println(numberFormatException.getMessage());
                }
            } while (true);

            String typeRental;
            AD:
            do {
                System.out.println("Chọn kiểu thuê");
                System.out.println("1.Giờ");
                System.out.println("2.Ngày");
                System.out.println("3.Tuần");
                System.out.println("4.Tháng");
                String select = scanner.nextLine();
                switch (select) {
                    case "1":
                        typeRental = "Giờ";
                        break AD;
                    case "2":
                        typeRental = "Ngày";
                        break AD;
                    case "3":
                        typeRental = "Tuần";
                        break AD;
                    case "4":
                        typeRental = "Tháng";
                        break AD;
                    default:
                        System.out.println("Nhập sai nhập lại");
                        break;
                }
            } while (true);

            String accompaniedService;
            AC:
            do {
                System.out.println("Chọn dịch vụ đi kèm");
                System.out.println("1.Nước miễn phí");
                System.out.println("2.Xôi miễn phí");
                System.out.println("3.Bia miễn phí");
                String select = scanner.nextLine();
                switch (select) {
                    case "1":
                        accompaniedService = "Nước miễn phí";
                        break AC;
                    case "2":
                        accompaniedService = "Xôi miễn phí";
                        break AC;
                    case "3":
                        accompaniedService = "Bia miễn phí";
                        break AC;
                    default:
                        System.out.println("Nhập sai nhập lại");
                        break;
                }
            } while (true);

            Room room = new Room(codeFacility, nameService, usableArea, rentalCost, maximumNumberOfPeople, typeRental, accompaniedService);
            facilityRepository.add(room);
        }
    }
}