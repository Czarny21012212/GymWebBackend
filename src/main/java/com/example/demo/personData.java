package com.example.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class personData {

    public personData() {}

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String firstName;
    private String lastName;
    private int age;
    private int pesel;
    private String gender;
    private String profileImg;
    private String email;
    private String phone;
    private String typeOfPass;
    private double price;
    private int numberOfDay;

    public personData(String firstName,String lastName, int age, int pesel, String gender, String profileImg, String email, String phone, String typeOfPass, double price, int numberOfDay) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.pesel = pesel;
        this.gender = gender;
        this.profileImg = profileImg;
        this.email = email;
        this.phone = phone;
        this.typeOfPass = typeOfPass;
        this.price = price;
        this.numberOfDay = numberOfDay;
    }

    public long getId() {return id;}
    public void setId(long id) {this.id = id;}

    public String getFirstName() {return firstName;}
    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}
    public void setLastName(String lastName) {this.lastName = lastName;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public int getPesel() {return pesel;}
    public void setPesel(int pesel) {this.pesel = pesel;}

    public String getGender() {return gender;}
    public void setGender(String gender) {this.gender = gender;}

    public String getProfileImg() {return profileImg;}
    public void setProfileImg(String profileImg) {this.profileImg = profileImg;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public String getPhone() {return phone;}
    public void setPhone(String phone) {this.phone = phone;}

    public String getTypeOfPass() {return typeOfPass;}
    public void setTypeOfPass(String typeOfPass) {this.typeOfPass = typeOfPass;}

    public double getPrice() {return price;}
    public void setPrice(double price) {this.price = price;}

    public int getNumberOfDay() {return numberOfDay;}
    public void setNumberOfDay(int numberOfDay) {this.numberOfDay = numberOfDay;}




}
