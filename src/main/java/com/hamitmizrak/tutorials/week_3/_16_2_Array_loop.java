package com.hamitmizrak.tutorials.week_3;

import java.util.Arrays;

public class _16_2_Array_loop {
    public static void main(String[] args) {
        String[] city={"Elazığ","Bingöl","Malatya","Sivas","Bitlis","Diyarbakır"};

        // 1.YOL Döngüsel (Iteratif)
        for (int i = 0; i < city.length; i++) {
            System.out.print(city[i]+" ");
        }

        System.out.println();

        // 2.YOL For each
        for (String data : city){
            System.out.print(data+" ");
        }

        System.out.println();
        // 3.YOL Stream
        //Dizilerde sıralama
        Arrays.sort(city);

        Arrays.stream(city).toList().forEach(temp-> System.out.print(temp+" "));

    }
}
