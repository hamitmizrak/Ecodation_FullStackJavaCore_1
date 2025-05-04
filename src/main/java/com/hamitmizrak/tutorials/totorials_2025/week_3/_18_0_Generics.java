 package com.hamitmizrak.tutorials.totorials_2025.week_3;

// Generics Class
public class _18_0_Generics<T> {
    // Data Types
    private String name;
    private T surname;// Generics Type

    // Constructor (Parametresiz)
    public _18_0_Generics() {
    }

    // Constructor (Parametreli)
    // Generics Constructor
    public _18_0_Generics(String name, T surname) {
        this.name = name;
        this.surname = surname;
    }

    // Generics Method
    public <T> void fullData(T data) {
        System.out.println(data);
    }

    // GETTER AND SETTER
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public T getSurname() {
        return surname;
    }

    public void setSurname(T surname) {
        this.surname = surname;
    }

    //toString
    @Override
    public String toString() {
        return "Week5_04_Generics{" +
                "name='" + name + '\'' +
                ", surname=" + surname +
                '}';
    }

    public static void main(String[] args) {
        _18_0_Generics genericsData=new _18_0_Generics();
        genericsData.setName("Hamit");
        System.out.println(genericsData.getName());

        _18_0_Generics genericsData2=new _18_0_Generics();
        genericsData2.setName("Hamit");
        // genericsData2.setSurname(true);
        // genericsData2.setSurname(44);
        // genericsData2.setSurname(44.16);
        genericsData2.setSurname("Mızrak");
        System.out.println(genericsData2);
        genericsData2.fullData(44);
    }
}
