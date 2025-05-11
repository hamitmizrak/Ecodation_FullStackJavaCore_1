package com.hamitmizrak.exception;


/**
 * 📌 Teacher özgü excepiton yazmak
 */

// ✅ Projeye özgü RuntimeException yazdık istersek Exception interface yazabilirdik
public class TeacherNotFoundException extends RuntimeException {


    // Parametresiz Constructor
    public TeacherNotFoundException() {
        super("Kayıt bulunamadı");
    }

    // Parametreli Constructor
    public TeacherNotFoundException(String message) {
        super(message);
    }
}
