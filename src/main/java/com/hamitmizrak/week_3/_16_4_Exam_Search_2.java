package com.hamitmizrak.week_3;

import java.util.Arrays;
import java.util.Scanner;

public class _16_4_Exam_Search_2 {
    public static void main(String[] args) {
        int[] sayilar = {3, 7, 15, 20, 25, 30};

        // Dizi sıralı olmalı
        Scanner scanner = new Scanner(System.in);

        // Clone

        while (true) {
            System.out.println("\nLütfen sayı giriniz");
            int aranan = scanner.nextInt();
            int sonuc = Arrays.binarySearch(sayilar, aranan);
            if (sonuc >= 0) {
                System.out.println("Aranan sayı " + aranan + ", " + sonuc + ". indexte bulundu.");
            } else {
                System.out.println("Sayı bulunamadı.");
            }
        }
    }
}
