package ua.petr.banking.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ua.petr.banking.enums.Currency;
import ua.petr.banking.model.Account;
import ua.petr.banking.model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AccountDao implements DaoInterface<Account>{

    private CustomerDao customerDao;

    public List<Account> accountList;

//    public CustomerDao getCustomerDao() {
//        return customerDao;
//    }
//
//    @Autowired
//    public void setCustomerDao(CustomerDao customerDao) {
//        this.customerDao = customerDao;
//    }

    public AccountDao(CustomerDao customerDao) {
        List<Account> tempList = new ArrayList<>();
       this.customerDao = customerDao;

       tempList.add(new Account(Currency.EUR, customerDao.customerList.get(0)));
        tempList.add(new Account(Currency.USD, customerDao.customerList.get(1)));
        tempList.add(new Account(Currency.CHF, customerDao.customerList.get(2)));

        this.accountList = tempList;
    }



    @Override
    public List<Account> findAll() {
        return accountList;
    }


    @Override
    public Account save(Account obj) {
        accountList.add(obj);

        return obj;
    }

    @Override
    public boolean delete(Account obj) {

        Optional<Account> account = accountList.stream().filter(a -> a.equals(obj)).findAny();

        if(account.isEmpty()){
            return false;
        }else {
            accountList.remove(account.get());
            return true;
        }
    }

    @Override
    public void deleteAll(List<Account> entities) {
        for (int i = 0; i < accountList.size(); i++) {
            for (int j = 0; j < entities.size(); j++) {
                if(accountList.get(i).getId().equals(entities.get(j).getId())){

                    accountList.remove(accountList.get(i));
                }
            }
        }
    }

    @Override
    public void saveAll(List<Account> entities) {
        for (int i = 0; i < accountList.size(); i++) {
            for (int j = 0; j < entities.size(); j++) {
                if(!accountList.get(i).getId().equals(entities.get(j).getId())){
                    accountList.add(entities.get(j));
                }
            }
        }
    }


    @Override
    public boolean deleteById(long id) {

        Optional<Account> account = accountList.stream().filter(a -> a.getId().equals(id)).findAny();

        if(account.isEmpty()){
            return false;
        }else {
            accountList.remove(account.get());
            return true;
        }
    }

    @Override
    public ResponseEntity<?> getOne(long id) {
        Optional<Account> account = accountList.stream().filter(a -> a.getId().equals(id)).findAny();

        if(account.isEmpty()){
            return ResponseEntity.badRequest().body("account with id: " + id + " does not exist");
        }else {
            return ResponseEntity.ok(account);
        }

    }
}
