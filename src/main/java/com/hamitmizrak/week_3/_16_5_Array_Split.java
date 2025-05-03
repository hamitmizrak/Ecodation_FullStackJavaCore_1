package com.hamitmizrak.week_3;

public class _16_5_Array_Split {
    public static void main(String[] args) {

        String data = "Ankara İstanbul İzmir Bursa";

        // 2.YOL
        String[] splitData = data.split(" ");
        for (String temp : splitData) {
            System.out.print(temp + " ");
        }

        System.out.println("\nDizi 1 eleman (0 indis)" + splitData[0]);
    }
}
