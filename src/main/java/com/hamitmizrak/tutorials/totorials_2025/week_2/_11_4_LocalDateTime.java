package com.hamitmizrak.tutorials.totorials_2025.week_2;

import java.time.LocalDateTime;

public class _11_4_LocalDateTime {
    public static void main(String[] args) {
        // LocalDateTime Java 8 sürümüyle
        // LocalDate : java.time
        // Sadece Tarih: yıl,ay,gün,saat,dakika,saniye,nanosaniye
        // Tercihi: Basit ve güvenli bir kullanım
        LocalDateTime now = LocalDateTime.now(); // bugünü tarihi
        System.out.println("Bugün: " + now);

        LocalDateTime specialDay = LocalDateTime.of(2025, 1, 27, 11, 10, 30);
        System.out.println("Belirli tarihi:" + specialDay);

    }
}