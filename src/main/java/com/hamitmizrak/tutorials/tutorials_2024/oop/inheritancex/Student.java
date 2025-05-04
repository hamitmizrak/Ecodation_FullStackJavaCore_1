package com.hamitmizrak.tutorials.tutorials_2024.oop.inheritancex;

import java.io.Serializable;

// Student
// POJO
public class Student extends Person implements Serializable  {

    // Sadece Student
    private String studentSpecial;


    // Serilestirme
    public static final long serialVersionUID=1L;

    public Student() {
    }

    public Student(String name, String surname,String studentSpecial) {
        super(name, surname);
        // studentSpecial=xyz;
        this.studentSpecial=studentSpecial;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentSpecial='" + studentSpecial + '\'' +
                "} " + super.toString();
    }
}//end Class
