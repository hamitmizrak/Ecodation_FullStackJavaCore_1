package com.hamitmizrak.week_2;


import java.util.Random;

public class _06_2_Random {
    public static void main(String[] args) {
        // Random

        // 1.YOl Math
        int sayi= (int) (Math.random()*10+1);
        System.out.println("sayı:" + sayi);

        // 2.YOL Random
        Random random= new Random();
        int sayi2=random.nextInt(100)+1;
        System.out.println("sayı:" + sayi2);
    }
}