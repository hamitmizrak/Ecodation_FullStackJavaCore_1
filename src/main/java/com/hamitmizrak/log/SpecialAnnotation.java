package com.hamitmizrak.log;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)                     // Çalışma zamanında erişilebilir
//@Target({ElementType.METHOD,ElementType.CONSTRUCTOR}) // Metotlarda ve Constructorlarda uygulanabilir
@Target({ElementType.METHOD})   // Yalnızca metotlara uygulanabilir
public @interface SpecialAnnotation {
}

// TEST CLASS
class Test {

    private String name;

    // @LogExecutionTime  // buraya bu anatasyonu ekleyemezsiniz.
    public Test() {
    }

    @SpecialAnnotation
    public static void process() {
        System.out.println("Bu metot loglanacak.");
    }

    // PSVM
    public static void main(String[] args) {
        Test.process();
    }
}
