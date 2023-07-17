package extra_exercises.model;

public class ForeignerPeople extends Person {
    private String nationality;

    public ForeignerPeople() {
    }

    public ForeignerPeople(String codePerson, String namePerson, String nationality) {
        super(codePerson, namePerson);
        this.nationality = nationality;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String infoForeignerToCSV() {
        return this.getCodePerson() + "," + this.getNamePerson() + "," + this.nationality;
    }

    @Override
    public String toString() {
        return "Khách hàng: " + super.toString() +
                ", quốc tịch: " + nationality;
    }
}
