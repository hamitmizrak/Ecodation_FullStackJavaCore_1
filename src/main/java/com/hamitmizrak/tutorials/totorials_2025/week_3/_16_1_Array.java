package com.hamitmizrak.tutorials.totorials_2025.week_3;

public class _16_1_Array {
    // Aynı türdeki verileri tek bir yerde saklamaya denir.
    // Array Hakkında
        /*
        sabit boyutludur. ( eleman sayısını başta yaz)
        Tek boyoutlu, Çift array
        Sıfırdan başlar saymaya
        Primitive Types Array
        Wrapper Types Array

         */
    public static void main(String[] args) {
        // Array(Dizi) tanımlama
        int[] sayilar = new int[4];
        sayilar[0] = 100;
        sayilar[1] = 1;
        sayilar[2] = 2;
        sayilar[3] = 39;
        System.out.println(sayilar[3]);

        try {
            System.out.println(sayilar[4]); // Olmayan eleman değeri: Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            //e.printStackTrace();
        } catch (Exception e) {
            //throw new RuntimeException(e);
        }


        System.out.println("kaç elemanlı: " + sayilar.length);
        System.out.println(sayilar.toString());

        // Clone
        int[] cloned = sayilar.clone();
        System.out.println(cloned[0]);
        System.out.println(cloned[5-1]);

        // Hashcode
        System.out.println("hashcode: "+sayilar.hashCode());
    }
}
