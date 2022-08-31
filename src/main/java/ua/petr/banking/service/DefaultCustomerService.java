package ua.petr.banking.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.petr.banking.dao.CustomerDao;
import ua.petr.banking.model.Customer;

import java.util.List;

@Service
public class DefaultCustomerService implements  CustomerService{

    private CustomerDao customerDao;

    public DefaultCustomerService(CustomerDao customerDao){
        this.customerDao = customerDao;
    }

    @Override
    public Customer save(Customer obj) {
        customerDao.save(obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        return customerDao.delete(obj);
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        customerDao.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Customer> entities) {
        customerDao.saveAll(entities);
    }

    @Override
    public List findAll() {
        return customerDao.findAll();
    }

    @Override
    public boolean deleteById(long id) {
        return customerDao.deleteById(id);
    }

    @Override
    public ResponseEntity<?> getOne(long id) {
        return customerDao.getOne(id);
    }

    public void update(Customer customer, long id) {
        customerDao.update(customer, id);
    }
}
