package model.facility.sub_class;

import model.facility.Facility;

public class Villa extends Facility {
    private String roomStandard;
    private float poolArea;
    private int floorsNumber;

    public Villa() {
    }

    public Villa(String codeService, String nameService, float usableArea, float rentalCost, int maximumNumberOfPeople, String typeRental, String roomStandard, float poolArea, int floorsNumber) {
        super(codeService, nameService, usableArea, rentalCost, maximumNumberOfPeople, typeRental);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floorsNumber = floorsNumber;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public float getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(float poolArea) {
        this.poolArea = poolArea;
    }

    public int getFloorsNumber() {
        return floorsNumber;
    }

    public void setFloorsNumber(int floorsNumber) {
        this.floorsNumber = floorsNumber;
    }

    public String infoVillaToCSV() {
        return this.getCodeService() + "," + this.getNameService() + "," + this.getUsableArea() + "," + this.getRentalCost() + "," + this.getMaximumNumberOfPeople() + "," + this.getTypeRental() + "," + this.roomStandard + "," + this.poolArea + "," + this.floorsNumber;
    }

    @Override
    public String toString() {
        return "Villa: " + super.toString()+
                ", tiêu chuẩn phòng: " + roomStandard +
                ", diện tích hồ bơi: " + poolArea +
                ", số tầng: " + floorsNumber;
    }
}
