package com.example.validate_form_dang_ky.dto;


import javax.validation.constraints.*;

public class UserDto{
    private int id;
    @Size(min = 5,max = 45,message = "Co do dai toi thieu 5, toi da 45 ky tu")
    private String firstName;
    @Size(min = 5,max = 45,message = " Co do dai toi thieu 5, toi da 5 ky tu")
    private String lastName;
    @Pattern(regexp = "^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$",message = "Nhap Sai Dinh Dang")
    private String phoneNumber;
    @Min(value = 18,message = "Tuoi phai lon hon 18")
    private int age;
    @NotNull
    @Email(message = "Nhap sai dinh dang email ")
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, int age, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
