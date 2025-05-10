package com.hamitmizrak.tutorials.totorials_2025.week_4._1_interfacex;

import java.io.Serializable;
import java.util.Date;

// POJO = field+getter and setter
// BEAN = POJO + Constructor + toString+ Method
public class TeacherDto implements ICrud, Serializable {

    // Serileştirme
    public static final long serialVersionUID = 1L;

    // Field (Global)
    private Integer id;
    private String name;
    private String surname;
    private Date createdDate;

    // Parametresiz Constructor
    public TeacherDto() {
        this.id = 0;
        this.name = "your name is not write there ...";
        this.surname = "your surname is not write there ...";
        this.createdDate = new Date();
    }

    // Parametreli Constructor
    public TeacherDto(Integer _id, String name, String surname) {
        id = _id;
        this.name = name;
        this.surname = surname;
        this.createdDate = new Date();
    }

    public TeacherDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // toString
    @Override
    public String toString() {
        return "TeacherDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    // Method
    public String fullName() { //Local
        return this.name + " " + this.surname;
    }

    // CRUD
    @Override
    public void create() {
        System.out.println("TeacherDto create");
    }

    @Override
    public void delete(int id) {
        System.out.println("TeacherDto delete" + id);
    }

    @Override
    public void update(int id) {
        System.out.println("TeacherDto update" + id);
    }


    // Getter And Setter
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


}
