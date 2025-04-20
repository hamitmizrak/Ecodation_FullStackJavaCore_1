package com.hamitmizrak.lesson_1;

public class _02_DataTypesCommonRules {
    public static void main(String[] args) {
        // Data type
        // Yazabiliriz.
        byte schoolCode=44;
        System.out.println(schoolCode);

        // Sayı ile bitebilir.
        byte schoolCode99=23;
        System.out.println(schoolCode99);

        // UnderScore ile başlayabilirsiniz.
        byte _schoolCode=23;
        System.out.println(_schoolCode);

        // Dolar ile başlayabilirsiniz.
        byte $schoolCode=55;
        System.out.println($schoolCode);


        // Yazamazsınız !!!!!!!!!.
        // kısa yazmak okunabilinirliği(Readability) öldürür. s1 yazmayın.
        // byte s1=663;

        // sayı ile başlanmaz.
        // byte 555schoolCode=663;

        // özel simgelerden($ ve _) haricinden başlanmaz.
        // byte &+~schoolCode=663;



    }
}
