package com.hamitmizrak.tutorials.week_2;

public class _03_2_Cast {

    public static void main(String[] args) {
        System.out.println(10+20);
        System.out.println(10+"20");
        System.out.println("10"+"20");
        // Cast(Tip dönüştürme) Bir veri türünü başka bir veri türüne dönüştürmektir.

        // 1-) Primitive Types Casting
        // 1-A) Implicit Casting (Ilkel veri türü (Otomatik dönüştürme))
        // küçük boyutlu bir veri türünü  büyük boyutlu veriye dönüştürmek
        byte number1=44;
        int number2=number1;

        // 1-B) Implicit Casting (Ilkel veri türü (Otomatik dönüştürme))
        // büyük  boyutlu bir veri türünü   küçük boyutlu veriye dönüştürmek
        int number3=14531091;
        byte number4=(byte) number3; // Explicit Casting(Mauel Dönüştürme)

        // 1-C) Primitive type => Wrapper
        int number5=44; // primitive type
        Integer number6= number5; //  Wrapper type => Boxing


        // 1-D) Primitive type => Wrapper
        Integer number7= 2323; //  Wrapper type
        int number8=number7; // primitive type  => unboxing


        // 1-E) Sayısal bir veriyi String'e çevirme
        int number9 = 44;
        String value10= String.valueOf(number9); // 1.YOL Nesne kullanıldı (Genelde Tercih edilmez)
        System.out.println(number9+16);
        System.out.println(value10+16);

        // to+verb: mak/mek
        // to+noun: a/e
        String value11= Integer.toString(number9); // 2.YOL Nesne kullanıldı (Genelde Tercih edilmez)
        System.out.println(number9+16);
        System.out.println(value11+16);

        // 1-F) String bir veriyi Sayısal'e çevirme
        String value12= "23";
        int number10=37;

        int number11=Integer.valueOf(value12); // 1.YOL
        int number12=Integer.parseInt(value12); // 2.YOL

        System.out.println(value12+number10);  // String+ number
        System.out.println(number10+number11); // number+number
        System.out.println(number10+number12); // number+number


        // 2- Referances Types Casting
        // 2-A) Upcasting (Yukarı dönüştürme)
        /*
        class Hayvan{}
        class Kedi extends Hayvan{}
        Hayvan hayvan1= new Kedi(); //upcasting child => parent
         */

        // 2-B) downcasting (Aşağı dönüştürme)
        /*
        class Hayvan{}
        class Kedi extends Hayvan{}
        Hayvan hayvan2 = new Hayvan(); //
        Kedi   kedi2 = (Kedi) hayvan2;           // downcasting parent  => child
         */
        /*
        if (hayvan2 instanceof Kedi){}
         */

    }
}
