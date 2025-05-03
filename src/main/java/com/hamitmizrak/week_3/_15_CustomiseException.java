package com.hamitmizrak.week_3;

public class _15_CustomiseException  extends Exception{
    public _15_CustomiseException(String message) {
        super(message);
    }


    public static void main(String[] args) throws _15_CustomiseException {
        throw new _15_CustomiseException("Merhabalar hatalı veri girdiniz...");
    }
}
