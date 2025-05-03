package com.hamitmizrak.week_3;

import java.io.IOException;

public class _14_Exception {

    // try -catch - finally - throws -throw
    public static void main(String[] args) throws ArithmeticException, IOException,ClassNotFoundException {
        //variable
        int number1 = 15;
        int number2 = 0;

        // try-catch
        try {
            // ististanın olacağı yer
            System.out.println(number1 / number2);
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            System.out.println("bu satır mutlaka çalışması gerekiyor");
        }

        System.out.println("son satır");
    }
}
