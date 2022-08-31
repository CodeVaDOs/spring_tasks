package ua.petr.banking.service;

import org.springframework.http.ResponseEntity;
import ua.petr.banking.model.Account;

import java.util.List;

public interface AccountService {
    public Account save(Account obj);
    public boolean delete(Account obj);
    public void deleteAll(List<Account> entities);
    public void saveAll(List<Account> entities);
    public List<Account> findAll();
    public boolean deleteById(long id);
    public ResponseEntity<?> getOne(long id);
}
