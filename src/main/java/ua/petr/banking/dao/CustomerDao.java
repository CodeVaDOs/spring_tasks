package ua.petr.banking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ua.petr.banking.enums.Currency;
import ua.petr.banking.model.Account;
import ua.petr.banking.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomerDao implements DaoInterface<Customer>{

    public List<Customer> customerList;
    private AccountDao accountDao;



    public CustomerDao(AccountDao accountDao) {
        List<Customer> tempList = new ArrayList<>();
        tempList.add(new Customer("petrov", "qwwry", 33));
        tempList.add(new Customer("ivanov", "www", 11));
        tempList.add( new Customer("sviridenko", "zxcv", 43));

        this.customerList = tempList;
        this.accountDao = accountDao;
    }

//    public AccountDao getAccountDao() {
//        return accountDao;
//    }
//
//    @Autowired
//    public void setAccountDao(AccountDao accountDao) {
//        this.accountDao = accountDao;
//    }

    @Override
    public List<Customer> findAll() {
        System.out.println(accountDao.accountList);
        return customerList;
    }

    @Override
    public Customer save(Customer obj) {
        customerList.add(obj);
        return obj;
    }

    @Override
    public boolean delete(Customer obj) {
        Optional<Customer> customer = customerList.stream().filter(c -> c.equals(obj)).findAny();

        if(customer.isEmpty()){
            return false;
        }else {
            customerList.remove(customer.get());
            return true;
        }
    }

    @Override
    public void deleteAll(List<Customer> entities) {
        System.out.println(entities);
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = 0; j < entities.size(); j++) {
                if(customerList.get(i).getId().equals(entities.get(j).getId())){

                    customerList.remove(customerList.get(i));
                }
            }
        }
    }

    @Override
    public void saveAll(List<Customer> entities) {
        for (int i = 0; i < customerList.size(); i++) {
            for (int j = 0; j < entities.size(); j++) {
                if(!customerList.get(i).getId().equals(entities.get(j).getId())){
                    customerList.add(entities.get(j));
                }
            }
        }
    }

    @Override
    public boolean deleteById(long id) {

        Optional<Customer> customer = customerList.stream().filter(с -> с.getId().equals(id)).findAny();

        if(customer.isEmpty()){
            return false;
        }else {
            customerList.remove(customer.get());
            return true;
        }
    }

    @Override
    public ResponseEntity<?> getOne(long id) {
        Optional<Customer> customer = customerList.stream().filter(с -> с.getId().equals(id)).findAny();

        if(customer.isEmpty()){
            return ResponseEntity.badRequest().body("customer with id: " + id + " does not exist");
        }else {
            return ResponseEntity.ok(customer);
        }

    }

    public void update(Customer customer, long id) {
        Optional<Customer> currentCustomer = customerList.stream().filter(c -> c.getId().equals(id)).findAny();

        if(currentCustomer.isPresent()){
            if(customer.getName() != null){
                currentCustomer.get().setName(customer.getName());
            }
            if(customer.getEmail() != null){
                currentCustomer.get().setEmail(customer.getEmail());
            }
            if(customer.getAge() != null){
                currentCustomer.get().setAge(customer.getAge());
            }
            if(customer.getAccounts()!= null){
                currentCustomer.get().setAccounts(customer.getAccounts());
            }
        }
    }
}
