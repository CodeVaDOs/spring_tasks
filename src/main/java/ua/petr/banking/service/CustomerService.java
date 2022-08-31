package ua.petr.banking.service;

import org.springframework.http.ResponseEntity;
import ua.petr.banking.model.Account;
import ua.petr.banking.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer save(Customer obj);
    public boolean delete(Customer obj);
    public void deleteAll(List<Customer> entities);
    public void saveAll(List<Customer> entities);
    public List<Customer> findAll();
    public boolean deleteById(long id);
    public ResponseEntity<?> getOne(long id);
}
