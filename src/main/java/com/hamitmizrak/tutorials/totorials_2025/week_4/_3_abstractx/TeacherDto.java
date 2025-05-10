package com.hamitmizrak.tutorials.totorials_2025.week_4._3_abstractx;

import java.io.Serializable;

// POJO = field+getter and setter
// BEAN = POJO + Constructor + toString+ Method
public class TeacherDto extends Person implements ICrud, Serializable {

    // Serileştirme
    public static final long serialVersionUID = 1L;

    // Field
    private String teacherPrice;

    // Constructor
    // Constructor (Parametresiz)
    public TeacherDto() {
        super();
    }

    // Constructor (Parametreli)
    public TeacherDto(Integer _id, String name, String surname) {
        super(_id, name, surname);
    }

    // Constructor (Parametreli)
    public TeacherDto(String name, String surname) {
        super(name, surname);
    }

    public TeacherDto(Integer _id, String name, String surname, String teacherPrice) {
        super(_id, name, surname);
        this.teacherPrice = teacherPrice;
    }

    // abstract
    @Override
    public void fullName() {
        System.out.println("Teacher Dto Abstract");
    }

    // toString
    @Override
    public String toString() {
        return "TeacherDto{} " + super.toString();
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

    @Override
    public void findById(int id) {
        System.out.println("teacher read" + id);
    }

}
