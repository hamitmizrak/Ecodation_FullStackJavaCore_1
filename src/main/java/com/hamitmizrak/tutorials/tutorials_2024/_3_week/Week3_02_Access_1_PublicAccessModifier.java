package com.hamitmizrak.tutorials.tutorials_2024._3_week;


import com.hamitmizrak.utils.SpecialColor;

public class Week3_02_Access_1_PublicAccessModifier {

    public String publicData="public data";
    private String privateData="private data";
    protected String protectedData="protected data";
     String defaultData="default data";

    public static void main(String[] args) {
        Week3_02_Access_1_PublicAccessModifier accessModifier= new Week3_02_Access_1_PublicAccessModifier();
        System.out.println(SpecialColor.BLUE+accessModifier.publicData+SpecialColor.RESET);
        System.out.println(SpecialColor.YELLOW+accessModifier.defaultData+SpecialColor.RESET);
        System.out.println(SpecialColor.PURPLE+accessModifier.protectedData+SpecialColor.RESET);
        System.out.println(SpecialColor.RED+accessModifier.privateData+SpecialColor.RESET);
    }
}
