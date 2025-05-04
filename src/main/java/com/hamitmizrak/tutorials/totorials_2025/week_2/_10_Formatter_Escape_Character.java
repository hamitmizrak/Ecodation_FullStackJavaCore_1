package com.hamitmizrak.tutorials.week_2;

import java.util.Formatter;

public class _10_Formatter_Escape_Character {
    public static void main(String[] args) {
        // Field
        String name="Hamit";
        int number=44;
        double price=14.53;

        // Formatter-1
        String result=String.format("isim: %s, numara: %d price: %f", name, number,price);
        System.out.println(result);

        // Formatter-2
        System.out.printf("isim: %s, numara: %d price: %f", name, number,price);
        System.out.println();

        // Formatter-3
        Formatter formatter2 = new Formatter();
        formatter2.format("isim: %s, numara: %d price: %f", name, number,price);
        System.out.println(formatter2);
        formatter2.close();  // Formatter kapat


        // Formatter-3
        Formatter formatter3 = new Formatter();
        // %10s = değerin 10 karakter boşluk oluştur
        // %5d  = değerin 5 karakter boşluk oluştur
        formatter3.format("isim: %10s, numara: %5d price: %.4f", name, number,price);
        System.out.println(formatter3);
        formatter3.close();  // Formatter kapat

        /*
        Escape Character(Kaçış Karakteri)
         \ Backslash
         \n: Yeni satır(newline)             Hamit\nMızrak
         \r: Satır Başı (Carriage Return)    Hamit\nMızrak
         \b: Geri alma (Backspace)           Hamit\bMızrak
         \t: tab boşluğu(tab space)          Hamit\tMızrak
         \": çift tırnak                     Hamit\"Mızrak
         \': tek tırnak                      Hamit\"Mızrak
         \\: Ters Eğri                       Hamit\\Mızrak
        */
    }
}