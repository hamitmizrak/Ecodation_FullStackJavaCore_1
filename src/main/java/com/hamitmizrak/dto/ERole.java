package com.hamitmizrak.dto;

/**
 * 📌 Kullanıcı Rollerini Tanımlayan Enum
 */
public enum ERole {
    STUDENT(1,"Öğrenci"),
    TEACHER(2,"Öğretmen"),
    ADMIN(3,"Yönetici");

    // Field
    // private yanına final yazarsak;
    // 1-) Hem değişkeni değiştirilemez olmasını sağlar
    // 2-) Hemde sadece GETTER metotlarını çağırır.
    private final Integer id;
    private final String description;

    // Parametreli Constructor
    // private Constructor'da Kullanıyoruz,
    // çünkü bu classı başka bir  yerde oluşturulmasına izin verilmesin
   private ERole(Integer id,String description) {
        this.id = id;
        this.description = description;
    }

    // GETTER
    public String getDescription() {
        return description;
    }

    public Integer getId() {
        return id;
    }

    /**
     * 📌 String’den Enum’a güvenli dönüşüm yapar.
     */
    public static ERole fromString(String role) {
        try {
            return ERole.valueOf(role.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("❌ Geçersiz rol: " + role);
        }
    }
} //end Enum ERole
