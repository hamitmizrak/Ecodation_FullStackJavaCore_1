package com.hamitmizrak.tutorials.totorials_2025.week_3;

public class _16_3_Array_Clone {
    public static void main(String[] args) {

        int[] original = {3, 7, 15, 20, 25, 30};
        int[] clone = original; // .clone() sadece shallow copy (yüzeysel kopya) yapar.

        // İç nesneler aynı referans mı?
        System.out.println("Aynı nesne mi? " + (original[0] == clone[0]));  // true

        System.out.println("1.Hali");
        System.out.println(original[0]);
        System.out.println(clone[0]);

        System.out.println("\n2.Hali");
        System.out.println(original[0]);
        clone[0]=99;
        System.out.println(original[0]);
        System.out.println(clone[0]);
    }
}
