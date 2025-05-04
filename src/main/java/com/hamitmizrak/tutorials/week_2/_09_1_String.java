package com.hamitmizrak.tutorials.week_2;

public class _09_1_String {
    public static void main(String[] args) {
        // String
        String value=" Java ÖĞRENİYORUM Java ";
        System.out.println(value);

        System.out.println("harf sayısı: "+value.length());
        System.out.println(value.trim()); // baş-son boşlukları kaldır:
        System.out.println("harf sayısı: "+value.trim().length());

        System.out.println("büyük karakter: "+value.toUpperCase());
        System.out.println("küçük karakter: "+value.toLowerCase());

        value=value.trim();
        System.out.println(value);
        System.out.println(value.substring(2)); //0 saymaya başlar
        System.out.println(value.substring(2).length());
        System.out.println(value.substring(0,6)); // 0<=X<=6-1

        System.out.println(value.startsWith("J"));
        System.out.println(value.endsWith("a"));
        System.out.println(value.endsWith("A"));
        System.out.println(value.toUpperCase().endsWith("A"));

        System.out.println(value.charAt(0)); //0'dan başlar saymaya

        System.out.println(value.contains("Java")); //0'dan başlar saymaya
        System.out.println(value.hashCode()); //hashCode: parmak izi

        System.out.println(value.equalsIgnoreCase("java öĞRENİYORUM Java")); // Şifreleme

        //Java ÖĞRENİYORUM Java
        System.out.println("soldan: "+value.indexOf("Java")); // soldan tarayarak gelmek(search)
        System.out.println("sağdan: "+value.lastIndexOf("Java")); // sağdan tarayarak gelmek

        String data=" ";
        System.out.println("isBlank: "+data.isBlank()); // Boş veya sadece boşuktan(whitespace)
        System.out.println("isEmpty: "+data.isEmpty()); // Sadece boş olup olmadığını kontrol eder

        // Repeat
        System.out.println(value.repeat(2));
        System.out.println(value.replace(value, "java ÖĞRENİYORUM java"));
    }
}