package com.hamitmizrak.controller;

import com.hamitmizrak.dao.IDaoGenerics;
import com.hamitmizrak.dao.StudentDao;
import com.hamitmizrak.dto.StudentDto;
import com.hamitmizrak.log.LogExecutionTime;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

public class StudentController implements IDaoGenerics<StudentDto> {

    // ✅ Loglama
    private static final Logger logger = Logger.getLogger(StudentController.class.getName());

    // ✅ Field
    private final StudentDao studentDao;

    // ✅ Parametresiz Constructor
    public StudentController() {
        this.studentDao = new StudentDao();
    }

    // ✅ CREATE
    @Override
    @LogExecutionTime
    public Optional<StudentDto> create(StudentDto studentDto) {
        if (studentDto == null || findByName(studentDto.getName()).isPresent()) {
            logger.warning("❌ Geçersiz veya mevcut olan öğrenci eklenemez");
            return Optional.empty();
        }
        Optional<StudentDto> createdStudent = studentDao.create(studentDto);
        createdStudent.ifPresentOrElse(
                temp -> logger.info("✅ Başarılı: Öğrenci eklendi"),
                () -> logger.warning("❌ Başarısız: Öğrenci eklenemedi"));
        return createdStudent;
    }

    // ✅ FIND BY NAME
    @Override
    @LogExecutionTime
    public Optional<StudentDto> findByName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("❌ Geçersiz isim girdiniz");
        }
        return studentDao.findByName(name.trim());
    }

    // ✅ FIND BY ID
    @Override
    @LogExecutionTime
    public Optional<StudentDto> findById(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("❌ Geçersiz ID girdiniz");
        }
        return studentDao.findById(id).or(() -> {
            logger.warning("❌ Öğrenci bulunamadı");
            return Optional.empty();
        });
    }

    // ✅ LIST
    @Override
    @LogExecutionTime
    public List<StudentDto> list() {
        List<StudentDto> studentDtoList = Optional.ofNullable(studentDao.list()).orElse(Collections.emptyList());
        if (studentDtoList.isEmpty()) {
            logger.info("Henüz kayıtlı bir öğrenci bulunmamaktadır.");
        }
        return studentDtoList;
    }

    // ✅ UPDATE
    @Override
    @LogExecutionTime
    public Optional<StudentDto> update(int id, StudentDto studentDto) {
        if (id <= 0 || studentDto == null) {
            throw new IllegalArgumentException("❌ Güncelleme için geçerli bir öğrenci bilgisi giriniz");
        }
        return studentDao.update(id, studentDto);
    }

    // ✅ DELETE
    @Override
    @LogExecutionTime
    public Optional<StudentDto> delete(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("❌ Silmek için geçerli bir öğrenci ID giriniz");
        }
        return studentDao.delete(id).or(() -> {
            logger.warning("❌ Silme işlemi başarısız: Öğrenci bulunamadı");
            return Optional.empty();
        });
    }

    //@LogExecutionTime
    public void choose() {
        studentDao.choose();
    }
} //end StudentController