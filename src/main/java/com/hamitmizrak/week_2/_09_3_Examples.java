package com.hamitmizrak.week_2;

import java.util.Scanner;

public class _09_3_Examples {
    public static void main(String[] args) {
        // Password- Repassword (Şifre kontrolü)
        // Validation
        // Password Create
        Scanner sc = new Scanner(System.in);

        // Field
        String databaseUsername="hamit",databasePassword="root";
        String dataPassword,dataUsername;

        // Sonsuz Döngü
        for (; ; ) {
            System.out.println("\nKullanıcı adınızı veya emailinizi giriniz...");
            dataUsername = sc.nextLine();

            System.out.println("\nŞifrenizi giriniz...");
            dataPassword = sc.nextLine();

            // equals: birebir aynı()
            // equalsIgnoreCase: case sentive değildir.
            if (databaseUsername.equalsIgnoreCase(dataUsername) &&  databasePassword.equals(dataPassword) ) {
                System.out.println("Şifreler aynı Admin sayfasına yönlendiriliyorsunuz");
                return; // sonlandırma
            } else {
                System.out.println("Kullanıcı adı veya Şifreler farklı");
            }
        } //end for
    }
}