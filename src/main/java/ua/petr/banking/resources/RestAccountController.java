package ua.petr.banking.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.petr.banking.model.Account;
import ua.petr.banking.model.Customer;
import ua.petr.banking.service.AccountService;
import ua.petr.banking.service.DefaultAccountService;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/accounts")
public class RestAccountController {
    private DefaultAccountService accountService;

    public RestAccountController(DefaultAccountService accountService){
        this.accountService = accountService;
    }

    @GetMapping()
    public List<Account> getAll() {
        return accountService.findAll();
    }
    @GetMapping("/{id}")

    public ResponseEntity<?> getOne(@PathVariable Long id) {

        return accountService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {

        return accountService.deleteById(id);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody Account account){
        return accountService.delete(account);
    }

    @PostMapping("")
    public Account save(@RequestBody Account account){
        accountService.save(account);
        return account;
    }

    @PostMapping("/deleteall")
    public void deleteAll(@RequestBody List<Account> list){
        accountService.deleteAll(list);

    }
    @PostMapping("/saveall")
    public void saveAll(@RequestBody List<Account> list){
        accountService.saveAll(list);

    }
}
