package com.hamitmizrak.tutorials.totorials_2025.week_4._2_inheritancex;

import java.io.Serializable;
import java.util.Date;

// POJO = field+getter and setter
// BEAN = POJO + Constructor + toString+ Method
public class TeacherDto extends Person  implements ICrud, Serializable {

    // Serileştirme
    public static final long serialVersionUID = 1L;



    // Constructor
    public TeacherDto() {
        super();
    }

    public TeacherDto(Integer _id, String name, String surname) {
        super(_id, name, surname);
    }

    public TeacherDto(String name, String surname) {
        super(name, surname);
    }

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

}
