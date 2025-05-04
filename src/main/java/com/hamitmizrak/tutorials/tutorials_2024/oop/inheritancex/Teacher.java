package com.hamitmizrak.tutorials.tutorials_2024.oop.inheritancex;

import java.io.Serializable;

// Student
// POJO
public class Teacher  extends Person  implements Serializable  {

    // Serilestirme
    public static final long serialVersionUID=1L;

    public Teacher() {
    }

    public Teacher(String name, String surname) {
        super(name, surname);
    }

    @Override
    public String toString() {
        return "Teacher{} " + super.toString();
    }
}//end Class
