package com.hamitmizrak.lesson_1;

public class _03_PrimitiveTypes {
    public static void main(String[] args) {
        // Primitive Types
        /*
        8 tane primitive type vardır.
        Stack hafızayı kullanırlar
        null değere alamazlar
        */
        // Tamsayılar
        System.out.println("// Tamsayılar //////////////////////////////////");
        byte primitiveByte=127;
        System.out.println("byte: "+primitiveByte);

        short primitiveShort=255;
        System.out.println("short: "+primitiveShort);

        int primitiveInt=255;
        System.out.println("int: "+primitiveInt);

        long primitiveLong=255L;  // l veya L
        System.out.println("long: "+primitiveLong);

        System.out.println("// Virgüllü Tamsayılar //////////////////////////////////");
        // Virgüllü Sayılar
        float primitiveFloat=255.0F; //f veya F
        System.out.println("float: "+primitiveFloat);

        double primitiveDouble=454545.12525; //f veya F
        System.out.println("double: "+primitiveDouble);

        System.out.println("// Char / Boolean //////////////////////////////////");
        char primitiveChar='A';
        primitiveChar='%';
        primitiveChar='\u4521';
        System.out.println("char: "+primitiveChar);

        boolean primitiveBoolean=true;
        primitiveBoolean=false;
        System.out.println("boolean: "+primitiveBoolean);

        // boolean primitiveBoolean2=null; //null yazamazsınız.
    }
}