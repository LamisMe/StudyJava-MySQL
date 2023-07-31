package model.facility.sub_class;

import model.facility.Facility;

public class House extends Facility {
    private String roomStandard;
    private int floorsNumber;

    public House() {
    }

    public House(String codeService, String nameService, float usableArea, float rentalCost, int maximumNumberOfPeople, String typeRental, String roomStandard, int floorsNumber) {
        super(codeService, nameService, usableArea, rentalCost, maximumNumberOfPeople, typeRental);
        this.roomStandard = roomStandard;
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public String infoHouseToCSV() {
        return this.getCodeService() + "," + this.getNameService() + "," + this.getUsableArea() + "," + this.getRentalCost() + "," + this.getMaximumNumberOfPeople() + "," + this.getTypeRental() + "," + this.roomStandard + "," + this.floorsNumber;
    }

    @Override
    public String toString() {
        return "House: " + super.toString() +
                ", tiêu chuẩn phòng: " + roomStandard +
                ", số tầng: " + floorsNumber;
    }
}
