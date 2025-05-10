package com.hamitmizrak.tutorials.totorials_2025.week_4._3_abstractx;

import java.io.Serializable;

// POJO = field+getter and setter
// BEAN = POJO + Constructor + toString+ Method
public class StudentDto extends Person implements ICrud, Serializable {

    // Serileştirme
    public static final long serialVersionUID = 1L;

    // Field
    private String studentCode;

    // Constructor (Parametresiz)
    public StudentDto() {
        super();
    }

    // Constructor (Parametreli)
    public StudentDto(Integer _id, String name, String surname) {
        super(_id, name, surname);
    }

    // Constructor (Parametreli)
    public StudentDto(String name, String surname) {
        super(name, surname);
    }

    public StudentDto(Integer _id, String name, String surname, String studentCode) {
        super(_id, name, surname);
        this.studentCode = studentCode;
    }

    // abstract
    @Override
    public void fullName() {
        System.out.println("Student Dto Abstract");
    }

    // toString
    @Override
    public String toString() {
        return "StudentDto{} " + super.toString();
    }

    // Method

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

    @Override
    public void findById(int id) {
        System.out.println("student read" + id);
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }
}
