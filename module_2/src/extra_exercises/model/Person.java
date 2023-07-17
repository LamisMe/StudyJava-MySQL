package extra_exercises.model;

import java.util.Objects;

public abstract class Person {
    private String codePerson;
    private String namePerson;

    public Person() {
    }

    public Person(String codePerson, String namePerson) {
        this.codePerson = codePerson;
        this.namePerson = namePerson;
    }

    public String getCodePerson() {
        return codePerson;
    }

    public void setCodePerson(String codePerson) {
        this.codePerson = codePerson;
    }

    public String getNamePerson() {
        return namePerson;
    }

    public void setNamePerson(String namePerson) {
        this.namePerson = namePerson;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(codePerson, person.codePerson) && Objects.equals(namePerson, person.namePerson);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codePerson, namePerson);
    }

    @Override
    public String toString() {
        return " Mã khách hàng: " + codePerson + '\'' +
                ", tên khách hàng: " + namePerson;
    }
}
