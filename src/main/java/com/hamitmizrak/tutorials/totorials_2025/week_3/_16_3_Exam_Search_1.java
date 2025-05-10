package com.hamitmizrak.tutorials.totorials_2025.week_3;

import java.util.Arrays;
import java.util.Scanner;

public class _16_3_Exam_Search_1 {
    public static void main(String[] args) {
        String[] city = new String[6];
        city[0] = "elazığ";
        city[1] = "bingöl";
        city[2] = "elazığ";
        city[3] = "malatya";
        city[4] = "sivas";
        city[5] = "diyarbakır";
        //{"elazığ", "Bingöl", "malatya", "sivas", "bitlis", "diyarbakır"};

        System.out.println(city[1]);
        // Dizilerde search
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLütfen bir şehir giriniz");
            String search = scanner.nextLine().trim().toLowerCase();
            int dataSearch = Arrays.binarySearch(city, search);
            if (dataSearch >= 0) {
                System.out.println(search + " şehiri vardır");
            } else {
                System.out.println("Aradığınız şehir yoktur");
            }
        }
    }
}
