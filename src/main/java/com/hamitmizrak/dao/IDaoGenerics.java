package com.hamitmizrak.dao;

import java.util.List;
import java.util.Optional;

/**
 * 📌 Generic DAO Arayüzü
 * CRUD işlemleri için temel arayüzdür.
 */

// ✅ Generics: Type Safe güvenliğini sağlar ve proje kodları genelleştirir.
public interface IDaoGenerics<T> {

    // CRUD
    // CREATE
    public Optional<T> create(T entity);

    // LIST
    public List<T> list();

    // FIND BY NAME
    public Optional<T> findByName(String name);

    // FIND BY ID
    public Optional<T> findById(int id);

    // UPDATE
    public Optional<T> update(int id, T entity);

    // DELETE
    public Optional<T> delete(int id);

    // CHOOSE
    public void choose();
}
