package com.hamitmizrak.week_2;

import java.util.Scanner;

public class _13_Exam_1 {

    // Field (Global)
    public String databaseUsername = "hamit", databasePassword = "root";
    private Scanner sc = new Scanner(System.in);

    // Kullanıcıdan username ve password almak
    public String[] userValue() {
        // Field (Local)
        String dataPassword, dataUsername;
        System.out.println("\nKullanıcı adınızı veya emailinizi giriniz...");
        dataUsername = sc.nextLine();
        System.out.println("\nŞifrenizi giriniz...");
        dataPassword = sc.nextLine();

        userValidation(dataPassword, dataUsername);

        return new String[]{dataUsername, dataPassword};
    }

    // Kullanıcıdan alınan verilerin validation
    public void userValidation(String username, String password) {
        if(username.isBlank()) {
            System.out.println("Kullanıcı adı boş geçilemez...");
        }

        if(password.isBlank()) {
            System.out.println("Şifre boş geçilemez...");
        }
    }


    public void mainProject() {
        // Password- Repassword (Şifre kontrolü)
        // Validation
        // Password Create
        _13_Exam_1 mainObject = new _13_Exam_1();
        String[] methodUserPassword = mainObject.userValue();
        String username = methodUserPassword[0];
        String password = methodUserPassword[1];

        // Sonsuz Döngü
        for (; ; ) {
            // equals: birebir aynı()
            // equalsIgnoreCase: case sentive değildir.
            if (databaseUsername.equalsIgnoreCase(username) && databasePassword.equals(password)) {
                System.out.println("Şifreler aynı Admin sayfasına yönlendiriliyorsunuz");
                return; // sonlandırma
            } else {
                System.out.println("Kullanıcı adı veya Şifreler farklı");
                mainProject();
            }
        } //end for
    }

    public static void main(String[] args) {
        // Instance
        _13_Exam_1 obj = new _13_Exam_1();
        obj.mainProject();
    }
}


/*
Cumartesi
------------
cast
Exception
Thread
File IO/NIO
Array


Pazar
------------
Cipher
Collections


Cumartesi-Pazar
------------
OOP (Inheritance+abstract+interface)
 */