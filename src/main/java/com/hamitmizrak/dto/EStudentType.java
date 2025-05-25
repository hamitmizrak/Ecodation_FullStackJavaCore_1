package com.hamitmizrak.dto;

/**
 * 📌 Öğrenci Türleri Enum
 */
public enum EStudentType {
    UNDERGRADUATE(1, "Lisans"),
    GRADUATE(2, "Yüksek Lisans"),
    PHD(3, "Doktora"),
    OTHER(4, "Diğer");

    // Field
    // private yanına final yazarsak;
    // 1-) Hem değişkeni değiştirilemez olmasını sağlar
    // 2-) Hemde sadece GETTER metotlarını çağırır.
    private final Integer id;
    private final String description;

    // Parametreli Constructor
    // private Constructor'da Kullanıyoruz,
    // çünkü bu classı başka bir  yerde oluşturulmasına izin verilmesin
    private EStudentType(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }
} //end EStudentType
