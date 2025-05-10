package com.hamitmizrak.tutorials.totorials_2025.week_4._2_inheritancex;


import java.util.Date;

public class MainInheritance {

    public static void main(String[] args) {
        // (instance: Örnekler)

        System.out.println("** STUDENT **");
        //  Instance-1
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Hamit");
        studentDto.setModifiedDate(new Date());
        System.out.println(studentDto.getName());
        System.out.println(studentDto.getSurname());
        System.out.println(studentDto.getModifiedDate());

        // Instance-2
        // Integer _id, String name, String surname
        StudentDto studentDto2 = new StudentDto(1, "Ahmet", "Yılmaz");
        System.out.println(studentDto2);

        System.out.println("** TEACHER **");
        // (instance: Örnekler)

        //  Instance-1
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setId(1);
        teacherDto.setName("Hamit");
        System.out.println(teacherDto);

        // Instance-2
        // Integer _id, String name, String surname
       TeacherDto teacherDto1 = new TeacherDto(1, "Ahmet", "Yılmaz");
        System.out.println(teacherDto1);
    }
}
