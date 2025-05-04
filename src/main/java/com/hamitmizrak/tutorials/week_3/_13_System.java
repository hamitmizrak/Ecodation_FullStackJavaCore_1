package com.hamitmizrak.tutorials.week_3;

import java.util.Date;
import java.util.Scanner;

public class _13_System {

    public static void main(String[] args) {

        // 1- Sistem Çıktısı
        System.out.println("Çıktı");

        // 2- Sistem Girdisi
        Scanner scanner= new Scanner(System.in);

        // 3- Hata mesajı (error)
        System.err.println("C dilinden gelen hata göstermek");

        // 4- Garbarage Collection Calling(GC çağırmak)
        System.gc();

        // 5- Data
        Date date= new Date(System.currentTimeMillis());
        System.out.println(date);

        // 6- Sistem çıkışı (logout) : Compiler çalışmasını durduruyor.
        System.exit(0);
    }
}
