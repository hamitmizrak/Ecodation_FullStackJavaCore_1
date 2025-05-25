package com.hamitmizrak.dto;

import java.time.LocalDate;
import java.util.Date;

/**
 * 📌 Temel Kişi (Person) DTO Sınıfı
 * Öğrenci ve öğretmen gibi varlıklar için ortak alanları içerir.
 */
public abstract class PersonDto {

    // Field ✅ protected için inheritance ve abstract yapılarında çoğunlukla kullanırız.
    protected Integer id;
    protected String name;
    protected String surname;
    protected LocalDate birthDate;
    protected final Date createdDate;

    /**
     * 📌 Varsayılan Constructor (Boş nesne oluşturur)
     */
    public PersonDto() {
        this.id = 0;
        this.name = "your name is not  write here ...";
        this.surname = "your surname is not  write here ...";
        this.birthDate = LocalDate.now();
        this.createdDate = new Date();  // Değiştirilemez alan
    }

    /**
     * 📌 Parametreli Constructor (Validation)
     */
    public PersonDto(Integer id, String name, String surname, LocalDate birthDate) {
        this.id = (id != null) ? id : 0; // Ternary Validation
        this.name = (name != null && !name.isBlank()) ? name : "Bilinmeyen";
        this.surname = (surname != null && !surname.isBlank()) ? surname : "Bilinmeyen";
        this.birthDate = (birthDate != null) ? birthDate : LocalDate.now();
        this.createdDate = new Date();  // Değiştirilemez alan
    }

    /**
     * 📌 Soyut Metot - Alt sınıflar tarafından uygulanmalıdır.
     */
    public abstract void displayInfo();

    // toString
    @Override
    public String toString() {
        return "PersonDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", createdDate=" + createdDate +
                '}';
    }

    // Getter & Setter Metotları

    // ID
    public Integer getId() {
        return id;
    }

    // Eğer ID boş gelirse default olarak Sıfır(0) ver
    public void setId(Integer id) {
        this.id = (id != null) ? id : 0;
    }

    // NAME
    public String getName() {
        return name;
    }

    // Eğer name null olarak gelirse default olarak :"Bilinmeyen" yazsın
    public void setName(String name) {
        this.name = (name != null && !name.isBlank()) ? name : "Bilinmeyen";
    }

    // SURNAME
    public String getSurname() {
        return surname;
    }

    // Eğer surname null olarak gelirse default olarak :"Bilinmeyen" yazsın
    public void setSurname(String surname) {
        this.surname = (surname != null && !surname.isBlank()) ? surname : "Bilinmeyen";
    }

    // BIRTHDATE
    public LocalDate getBirthDate() {
        return birthDate;
    }

    // Eğer name null olarak gelirse default olarak :"Bilinmeyen" yazsın
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = (birthDate != null) ? birthDate : LocalDate.now();
    }

    public Date getCreatedDate() {
        return createdDate; // Değiştirilemez
    }
} // end PersonDto
