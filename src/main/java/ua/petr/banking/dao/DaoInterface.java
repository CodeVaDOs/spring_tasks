package ua.petr.banking.dao;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DaoInterface<T> {
    public T save(T obj);
    public boolean delete(T obj);
    public void deleteAll(List<T> entities);
    public void saveAll(List<T> entities);
    public List<T> findAll();
    public boolean deleteById(long id);
    public ResponseEntity<?> getOne(long id);
}
