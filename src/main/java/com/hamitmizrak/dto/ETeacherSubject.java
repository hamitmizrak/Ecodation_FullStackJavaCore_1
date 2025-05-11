package com.hamitmizrak.dto;

/**
 * 📌 Öğretmen Branşları Enum
 */
public enum ETeacherSubject {
    MATHEMATICS("Matematik"),
    CHEMISTRY("Kimya"),
    BIOLOGY("Biyoloji"),
    HISTORY("Tarih"),
    COMPUTER_SCIENCE("Bilgisayar Bilimi"),
    OTHER("Diğer");

    // Field
    private final String description;

    // Parametreli Constructor
    ETeacherSubject(String description) {
        this.description = description;
    }

    // Getter
    public String getDescription() {
        return description;
    }
}
