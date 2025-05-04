package com.hamitmizrak.tutorials.week_4;

public class _18_1_Class {

    // Field
    private String name;
    private String surname;
    private int number;

    // Parametresiz Constructor (Alt+INS)
    public  _18_1_Class() {
    }

    // Parametreli Constructor (Alt+INS)
    public _18_1_Class(String name, int number, String surname) {
        this.name = name;
        this.number = number;
        this.surname = surname;
    }

    // Overloading: Parametreli Constructor (Alt+INS)
    public _18_1_Class(String name, String surname) {
        this.name = name;
        this.number = number;
        this.surname = surname;
    }

    // Method


    // Encapsulation
    // Getter And Setter
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
