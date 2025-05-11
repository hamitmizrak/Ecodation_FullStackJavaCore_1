package com.hamitmizrak.dto;

public enum ERoles {
    //STUDENT,TEACHER,ADMIN

    // Constructor
    STUDENT(1,"öğrenci"),TEACHER(2,"öğretmen"),ADMIN(3,"admin");

    // Field
    private final int id;
    private final String description;

    // Constructor
    // private: ERoles için instance oluşmaması içindir
    private ERoles(int id, String description) {
        this.id = id;
        this.description = description;
    }

    // GETTER değişkenlerde final yazarsanız SETTER gelmez
    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}

class EnumTest{
    public static void main(String[] args) {
        ERoles role= ERoles.TEACHER;
        System.out.println(role);
        System.out.println("NAME: "+role.name());
        System.out.println("ORDINAL: "+role.ordinal()); // Sıfırdan saymaya başlar
        System.out.println("toString: "+role.toString()); // String'e çevir
        System.out.println("values: "+role.values()[0]); // String'e çevir
    }
}
