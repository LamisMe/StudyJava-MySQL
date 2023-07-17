package extra_exercises.model;

public class VietNamPeople extends Person {
    private String typeCustomer;
    private long consumptionNorms;

    public VietNamPeople() {
    }

    public VietNamPeople(String codePerson, String namePerson, String typeCustomer, long consumptionNorms) {
        super(codePerson, namePerson);
        this.typeCustomer = typeCustomer;
        this.consumptionNorms = consumptionNorms;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public long getConsumptionNorms() {
        return consumptionNorms;
    }

    public void setConsumptionNorms(long consumptionNorms) {
        this.consumptionNorms = consumptionNorms;
    }

    public String infoVietNamToCSV() {
        return this.getCodePerson() + "," + this.getNamePerson() + "," + this.typeCustomer + "," + this.consumptionNorms;
    }

    @Override
    public String toString() {
        return "Khách hàng: " + super.toString() +
                ", loại khách hàng: " + typeCustomer +
                ", định mức tiêu thụ: " + consumptionNorms;
    }
}
