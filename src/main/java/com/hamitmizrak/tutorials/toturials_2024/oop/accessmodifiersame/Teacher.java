package com.hamitmizrak.tutorials.toturials_2024.oop.accessmodifiersame;

public class Teacher {
    public static void main(String[] args) {
        Student student=new Student();
        System.out.println(student.publicData);
        System.out.println(student.protectedData);
        //System.out.println(student.privateData);
        System.out.println(student.defaultData);
    }
}
