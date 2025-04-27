package com.hamitmizrak.week_2;

public class _12_Method {

    // 1- voidli Parametresiz
    public static void voidliParametresiz() {
        System.out.println("1- voidli Parametresiz");
    }

    // 2-voidli Parametreli
    public static void voidliParametreli(String name, int number) {
        System.out.println("2- voidli Parametreli: " + name + " " + number);
    }


    // 3-voidsiz Parametresiz
    public static String voidsizParametresiz() {
        return "3- voidsiz Parametresiz";
    }


    // 4- voidsiz Parametreli
    public static String voidsizParametreli(String name, int number) {
        return "4- voidsiz Parametreli: " + name + " " + number;
    }


    public static void main(String[] args) {
        // Method
        _12_Method.voidliParametresiz();
        _12_Method.voidliParametreli("Hamit Mızrak", 44);

        String result3 = _12_Method.voidsizParametresiz();
        System.out.println(result3);

        String result4 = _12_Method.voidsizParametreli("Hamit Mızrak", 44);
        System.out.println(result4);
    }
}