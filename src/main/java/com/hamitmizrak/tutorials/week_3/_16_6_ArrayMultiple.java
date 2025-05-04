package com.hamitmizrak.tutorials.week_3;

public class _16_6_ArrayMultiple {
    public static void main(String[] args) {

        // Tek boyutlu
        int[] sayilar = {3, 7, 15, 20, 25, 30};

        // Çift boyutlu (2D) Matrix
        int[][] matris = new int[3][3];
        matris[0][0] = 1;
        matris[0][1] = 2;
        matris[0][2] = 3;
        matris[1][0] = 4;
        matris[1][1] = 5;
        matris[1][2] = 6;
        matris[2][0] = 7;
        matris[2][1] = 8;
        matris[2][2] = 9;

        for (int i = 0; i < matris.length; i++) {  // satır
            for (int k = 0; k < matris[i].length; k++) {  // sutun
                System.out.print(matris[i][k] + " ");
            }
            System.out.println();
        }
    }
}


/*

Pazar
------------
File IO/NIO
Collections
- List
- Set
- Map

Cumartesi-Pazar
------------
OOP
Class
access modifier
static
constructor (parametresiz)
constructor (parametreli)
toString

Inheritance (this, super)
abstract
interface
polymorphism

Thread
Lambda Expression
Java 8 ile gelen özellikler
Cipher
 */