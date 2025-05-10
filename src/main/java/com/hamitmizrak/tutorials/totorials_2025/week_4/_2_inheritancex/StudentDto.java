package com.hamitmizrak.tutorials.totorials_2025.week_4._2_inheritancex;

import java.io.Serializable;
import java.util.Date;

// POJO = field+getter and setter
// BEAN = POJO + Constructor + toString+ Method
public class StudentDto extends Person implements ICrud, Serializable {

    // Serileştirme
    public static final long serialVersionUID = 1L;

    // Constructor
    public StudentDto() {
        super();
    }

    public StudentDto(Integer _id, String name, String surname) {
        super(_id, name, surname);
    }

    public StudentDto(String name, String surname) {
        super(name, surname);
    }

    // Method
    public String fullName() { //Local
        return super.getName() + " " + super.getSurname();
    }


    @Override
    public String toString() {
        return "StudentDto{} " + super.toString();
    }

    // CRUD
    @Override
    public void create() {
        System.out.println("student Create");
    }

    @Override
    public void delete(int id) {
        System.out.println("student Delete" + id);
    }

    @Override
    public void update(int id) {
        System.out.println("student update" + id);
    }

}
