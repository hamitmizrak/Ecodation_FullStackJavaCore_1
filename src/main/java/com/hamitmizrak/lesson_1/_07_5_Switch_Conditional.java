package com.hamitmizrak.lesson_1;


public class _07_5_Switch_Conditional {
    public static void main(String[] args) {
        // Conditional (Multiple)
        int number = 3;

        // conditional
        if (number == 1) {
            System.out.println("1");
        } else if (number == 2) {
            System.out.println("2");
        } else if (number == 3) {
            System.out.println("3");
        } else if (number == 4) {
            System.out.println("4");
        } else if (number == 5) {
            System.out.println("5");
        } else {
            System.out.println("1<=X<=5 dışındır.");
        }

        // switch
        switch (number) {
            case 1:
                System.out.println("1");
                break;
            case 2:
                System.out.println("2");
                break;
            case 3:
                System.out.println("3");
                break;
            case 4:
                System.out.println("4");
                break;
            case 5:
                System.out.println("5");
                break;
            default:
                System.out.println("1<=X<=5 dışındır.");
                break;
        }
    }
}



/*

Loop
String
Method
Exception
Array
Collections
OOP (Inheritance+abstract+interface)
 */