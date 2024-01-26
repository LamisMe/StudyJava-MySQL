package bai_3.model;

import java.util.Objects;

public class Employee implements Comparable<Employee>{
    private String codeEmployee;
    private String nameEmployee;
    private String dateOfBirth;
    private String position;
    private long salary;

    public Employee() {
    }

    public Employee(String codeEmployee, String nameEmployee, String dateOfBirth, String position, long salary) {
        this.codeEmployee = codeEmployee;
        this.nameEmployee = nameEmployee;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.salary = salary;
    }

    public String getCodeEmployee() {
        return codeEmployee;
    }

    public void setCodeEmployee(String codeEmployee) {
        this.codeEmployee = codeEmployee;
    }

    public String getNameEmployee() {
        return nameEmployee;
    }

    public void setNameEmployee(String nameEmployee) {
        this.nameEmployee = nameEmployee;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(codeEmployee, employee.codeEmployee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codeEmployee);
    }

    public String infoToCSVEmployee() {
        return this.codeEmployee + "," + this.nameEmployee + "," + this.dateOfBirth + "," + this.position + "," + this.salary;
    }

    @Override
    public String toString() {
        return "Nhân viên: " +
                "Mã nhân viên: " + codeEmployee +
                ", tên nhân viên: " + nameEmployee +
                ", ngày tháng năm sinh: " + dateOfBirth +
                ", vị trí: " + position +
                ", lương: " + salary;
    }

    @Override
    public int compareTo(Employee o) {
        return (int) (o.salary - this.salary);
    }
}
