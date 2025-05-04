package com.hamitmizrak.tutorials.week_2;

public class _09_2_Concat {
    public static void main(String[] args) {
        // String
        String city1="Malatya", city2="Sivas", city3="Elazığ", city4="Diyarbakır";

        // 1- sum operand
        System.out.println(city1+city2+city3+city4);

        // 2- concat String
        System.out.println(city1.concat(city2).concat(city3) .concat(city4));

        // 3- String Buffer
        StringBuffer stringBuffer= new StringBuffer();
        stringBuffer.append(city1).append(city2).append(city3).append(city4);
        String buffer = stringBuffer.toString();
        System.out.println(buffer);

        // 4- String Builder
        StringBuilder stringBuilder= new StringBuilder();
        stringBuilder.append(city1).append(city2).append(city3).append(city4);
        String builder = stringBuffer.toString();
        System.out.println(builder);
    }
}