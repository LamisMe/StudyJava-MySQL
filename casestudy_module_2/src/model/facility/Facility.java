package model.facility;

import java.util.Objects;

public class Facility {
    private String codeService;
    private String nameService;
    private float usableArea;
    private float rentalCost;
    private int maximumNumberOfPeople;
    private String typeRental;

    public Facility() {
    }

    public Facility(String codeService, String nameService, float usableArea, float rentalCost, int maximumNumberOfPeople, String typeRental) {
        this.codeService = codeService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.rentalCost = rentalCost;
        this.maximumNumberOfPeople = maximumNumberOfPeople;
        this.typeRental = typeRental;
    }

    public String getCodeService() {
        return codeService;
    }

    public void setCodeService(String codeService) {
        this.codeService = codeService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public float getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(float usableArea) {
        this.usableArea = usableArea;
    }

    public float getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(float rentalCost) {
        this.rentalCost = rentalCost;
    }

    public int getMaximumNumberOfPeople() {
        return maximumNumberOfPeople;
    }

    public void setMaximumNumberOfPeople(int maximumNumberOfPeople) {
        this.maximumNumberOfPeople = maximumNumberOfPeople;
    }

    public String getTypeRental() {
        return typeRental;
    }

    public void setTypeRental(String typeRental) {
        this.typeRental = typeRental;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Facility facility = (Facility) o;
        return Objects.equals(codeService, facility.codeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeService);
    }

    @Override
    public String toString() {
        return "Mã dịch vụ: " + codeService +
                ", tên dịch vụ: " + nameService +
                ", diện tích sử dụng: " + usableArea +
                ", chi phí thuê: " + rentalCost +
                ", số lượng người tối đa: " + maximumNumberOfPeople +
                ", kiểu thuê: " + typeRental;
    }
}
