package model.person;

public class Employee extends Person {
    private String level;
    private String location;
    private long wage;

    public Employee() {
    }

    public Employee(String level, String location, long wage) {
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public Employee(String id, String name, String dateOfBirth, String gender, String idCard, String phoneNumber, String email, String level, String location, long wage) {
        super(id, name, dateOfBirth, gender, idCard, phoneNumber, email);
        this.level = level;
        this.location = location;
        this.wage = wage;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getWage() {
        return wage;
    }

    public void setWage(long wage) {
        this.wage = wage;
    }

    public String toInfoCSVEmployee() {
        return this.getId() + "," + this.getName() + "," + this.getDateOfBirth() + "," + this.getGender() + "," + this.getIdCard() + "," + this.getPhoneNumber() + "," + this.getEmail() + "," + this.getLevel() + "," + this.getLocation() + "," + this.getWage();
    }

    @Override
    public String toString() {
        return "Nhân Viên: " + super.toString() +
                ", Trình Độ: " + level +
                ", Vị Trí: " + location +
                ", Lương: " + wage;
    }
}
