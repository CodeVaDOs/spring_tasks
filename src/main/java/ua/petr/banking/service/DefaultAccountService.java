package ua.petr.banking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ua.petr.banking.dao.AccountDao;
import ua.petr.banking.dao.DaoInterface;
import ua.petr.banking.model.Account;

import java.util.List;

@Service
public class DefaultAccountService implements AccountService{


    private AccountDao accountDao;

    public DefaultAccountService(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account save(Account obj) {
        return accountDao.save(obj);
    }

    @Override
    public boolean delete(Account obj) {
        return accountDao.delete(obj);
    }

    @Override
    public void deleteAll(List<Account> entities) {
        accountDao.deleteAll(entities);
    }

    @Override
    public void saveAll(List<Account> entities) {
        accountDao.saveAll(entities);
    }



    @Override
    public boolean deleteById(long id) {

        return accountDao.deleteById(id);
    }

    @Override
    public ResponseEntity<?> getOne(long id) {
        return accountDao.getOne(id);
    }
}
