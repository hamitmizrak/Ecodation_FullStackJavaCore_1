package com.hamitmizrak.tutorials.totorials_2025.week_2;

import java.util.Scanner;

public class _13_Exam_1 {

    // Field (Global)
    private final String DATABASE_USERNAME = "hamit";
    private final String DATABASE_PASSWORD = "root";
    private final Scanner sc = new Scanner(System.in);

    // Kullanıcıdan username ve password almak
    public String[] userValue() {
        // Field (Local)
        String dataPassword, dataUsername;

        // Username Input
        while (true) {
            System.out.println("\nKullanıcı adınızı veya emailinizi giriniz... \n en az 3 karakter giriniz");
            dataUsername = sc.nextLine().trim();
            if (userValidation(dataUsername, "Kullanıcı Adı")) {
                break;
            }
        }

        while (true) {
            System.out.println("\nŞifrenizi giriniz. \nEn az 6 karakter olmalı\n en az 1 harf \n en az 1 rakam");
            dataPassword = sc.nextLine().trim();
            if (userValidation(dataUsername, "Şifre")) {
                break;
            }
        }
        return new String[]{dataUsername, dataPassword};
    }

    // Kullanıcıdan alınan verilerin validation
    public boolean userValidation(String value, String fieldName) {

        // value
        if (value.isBlank()) {
            System.out.println("🚦🚦 " + fieldName + " boş geçilemez");
            return false;
        }

        // Kullanıcı Adı kuralları
        if (fieldName.equalsIgnoreCase("Kullanıcı Adı")) {
            if (value.length() < 3) {
                System.out.println("🚦🚦 Kullanıcı adı en az 3 karakter olmalıdır.");
                return false;
            }
            if (!value.matches("^[a-zA-Z0-9._-]+${3,16}")) {
                System.out.println("🚦🚦 Kullanıcı adı sadece harf, rakam, '.', '-','_' karakterleri içermelidir ");
            }
        }

        // Kullanıcı Şifre kuralları
        if (fieldName.equalsIgnoreCase("Şifre")) {
            if (value.length() < 6) {
                System.out.println("🚦🚦 Kullanıcı şifre en az 6 karakter olmalıdır.");
                return false;
            }
            if (!value.matches(".*[a-zA-Z].*]")) {
                System.out.println("🚦🚦 Kullanıcı şifresi en az 1 harf içermelidir ");
                return false;
            }

            if (!value.matches(".*[0-9].*]")) {
                System.out.println("🚦🚦 Kullanıcı şifresi en az 1 rakam içermelidir ");
                return false;
            }
        }
        return true;
    }


    public void mainProject() {
        System.out.println("\n Kullanıcı Giriş Paneli");
        // Sonsuz Döngü
        for (; ; ) {
            String[] methodUserPassword = userValue();
            String username = methodUserPassword[0];
            String password = methodUserPassword[1];

            if (DATABASE_USERNAME.equalsIgnoreCase(username) && DATABASE_PASSWORD.equals(password)) {
                System.out.println("Giriş Başarılı Admin sayfasına yönlendiriliyorsunuz");
                return; // sonlandırma
            } else {
                System.out.println("😡😡Kullanıcı adı veya Şifreler farklı");
            }
        }
    } //end for

    public static void main(String[] args) {
        // Instance
        _13_Exam_1 obj = new _13_Exam_1();
        obj.mainProject();
    }
}