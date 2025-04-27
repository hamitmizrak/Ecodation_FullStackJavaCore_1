package com.hamitmizrak.week_2;


public class _04_WrapperTypes {
    public static void main(String[] args) {
        // Wrapper Types
        /*
        wrapper type vardır.
        Heap hafızayı kullanırlar
        null değere alabilir
        */
        // Tamsayılar
        System.out.println("// Tamsayılar //////////////////////////////////");
        Byte wrapperByte=127;
        System.out.println("byte: "+wrapperByte);

        Short wrapperShort=255;
        System.out.println("short: "+wrapperShort);

        Integer wrapperInt=255;
        System.out.println("int: "+wrapperInt);

        Long wrapperLong=255L;  // l veya L
        System.out.println("long: "+wrapperLong);

        System.out.println("// Virgüllü Tamsayılar //////////////////////////////////");
        // Virgüllü Sayılar
        Float wrapperFloat=255.0F; //f veya F
        System.out.println("float: "+wrapperFloat);

        Double wrapperDouble=454545.12525; //f veya F
        System.out.println("double: "+wrapperDouble);

        System.out.println("// Char / Boolean //////////////////////////////////");
        Character wrapperChar='A';
        wrapperChar='%';
        wrapperChar='\u4521';
        System.out.println("char: "+wrapperChar);

        Boolean wrapperBoolean=true;
        wrapperBoolean=false;
        System.out.println("boolean: "+wrapperBoolean);
        Boolean primitiveBoolean2=null; //null yazabilirsiniz.
        System.out.println(primitiveBoolean2);
    }
}