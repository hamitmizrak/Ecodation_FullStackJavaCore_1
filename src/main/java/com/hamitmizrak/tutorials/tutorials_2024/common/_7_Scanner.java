package com.hamitmizrak.tutorials.tutorials_2024.common;

import java.util.Scanner;

public class _7_Scanner {
    public static void main(String[] args) {
        System.out.println("Scanner");
        int number=10;
        System.out.println(number);

        Scanner scanner=new Scanner(System.in);
        System.out.println("Lütfen bir sayı giriniz");
        int scannerNumber=scanner.nextInt();
        System.out.println(scannerNumber);

        // Scanner Close
        scanner.close();
    }
}
