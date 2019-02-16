package com.company.model;

import java.sql.Date;

public class Student {
    private Integer id;
    private String firstName;
    private String lastName;
    private Date birthday;
    private Sex sex;

    public Student(){}

    public Student(Integer id, String firstName, String lastName, Date birthday, Sex sex) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.sex = sex;
    }

    public enum Sex {
        male, female
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer id) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        String result = String.format(
                "| id: %7d | FirstName: %10s | LastName: %10s | Sex: %7s | Birthday: %10s |",
                id, firstName, lastName, sex, birthday);
        return result;
    }
}
