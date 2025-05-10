package com.hamitmizrak.tutorials.totorials_2025.week_4._3_abstractx;

import java.util.Date;

abstract public class Person {

    // Field (Global)
    private Integer id;
    private String name;
    private String surname;
    private Date createdDate;
    private Date modifiedDate;

    // Constructor
    // Parametresiz Constructor
    public Person() {
        this.id = 0;
        this.name = "your name is not write there ...";
        this.surname = "your surname is not write there ...";
        this.createdDate = new Date();
    }

    // Parametreli Constructor
    public Person(Integer _id, String name, String surname) {
        id = _id;
        this.name = name;
        this.surname = surname;
        this.createdDate = new Date();
    }

    // Parametreli Constructor
    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // Gövdesiz Metot (abstract)
    abstract public void fullName();

    // ToString
    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    // GETTER AND SETTER
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}
