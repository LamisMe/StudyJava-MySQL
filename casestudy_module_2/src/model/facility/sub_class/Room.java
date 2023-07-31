package model.facility.sub_class;

import model.facility.Facility;

public class Room extends Facility {
    private String accompaniedService;

    public Room() {
    }

    public Room(String codeService, String nameService, float usableArea, float rentalCost, int maximumNumberOfPeople, String typeRental, String accompaniedService) {
        super(codeService, nameService, usableArea, rentalCost, maximumNumberOfPeople, typeRental);
        this.accompaniedService = accompaniedService;
    }

    public String getAccompaniedService() {
        return accompaniedService;
    }

    public void setAccompaniedService(String accompaniedService) {
        this.accompaniedService = accompaniedService;
    }

    public String infoRoomToCSV() {
        return this.getCodeService() + "," + this.getNameService() + "," + this.getUsableArea() + "," + this.getRentalCost() + "," + this.getMaximumNumberOfPeople() + "," + this.getTypeRental() + "," + this.accompaniedService;
    }

    @Override
    public String toString() {
        return "Room: " + super.toString() +
                ", dịch vụ đi kèm: " + accompaniedService;
    }
}
