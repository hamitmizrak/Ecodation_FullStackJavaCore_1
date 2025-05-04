package com.hamitmizrak.tutorials.toturials_2024._4_week;

public class Week4_01_Enum {
    public static void main(String[] args) {
        TutorialsEStudentType eStudentType= TutorialsEStudentType.GRADUATE;
        System.out.println(eStudentType);
        System.out.println(eStudentType.name());
        System.out.println(eStudentType.ordinal());
    }
}
