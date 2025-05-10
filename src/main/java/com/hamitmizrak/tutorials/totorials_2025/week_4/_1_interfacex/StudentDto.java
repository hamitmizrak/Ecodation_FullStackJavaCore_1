package com.hamitmizrak.tutorials.totorials_2025.week_4._1_interfacex;

import java.io.Serializable;
import java.util.Date;

// POJO = field+getter and setter
// BEAN = POJO + Constructor + toString+ Method
public class StudentDto implements IPersonCommon, Serializable {

    // Serileştirme
    public static final long serialVersionUID = 1L;

    // Field (Global)
    private Integer id;
    private String name;
    private String surname;
    private Date createdDate;

    // Parametresiz Constructor
    public StudentDto() {
        this.id = 0;
        this.name = "your name is not write there ...";
        this.surname = "your surname is not write there ...";
        this.createdDate = new Date();
    }

    // Parametreli Constructor
    public StudentDto(Integer _id, String name, String surname) {
        id = _id;
        this.name = name;
        this.surname = surname;
        this.createdDate = new Date();
    }

    public StudentDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    // toString


    @Override
    public String toString() {
        return "StudentDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", createdDate=" + createdDate +
                '}';
    }

    // Method
    public String fullName() { //Local
        return this.name + " " + this.surname;
    }

    // CRUD
    @Override
    public void create() {
        System.out.println("student Create");
    }

    @Override
    public void delete(int id) {
        System.out.println("student Delete" + id);
    }

    @Override
    public void update(int id) {
        System.out.println("student update" + id);
    }


    // Getter And Setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


    // PSVM
    public static void main(String[] args) {
        // (instance: Örnekler)

        //  Instance-1
        StudentDto studentDto = new StudentDto();
        studentDto.setId(1);
        studentDto.setName("Hamit");
        System.out.println(studentDto);

        // Instance-2
        // Integer _id, String name, String surname
        StudentDto studentDto2 = new StudentDto(1, "Ahmet", "Yılmaz");
        System.out.println(studentDto2);
    }


}
