package ua.petr.banking.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.petr.banking.dao.CustomerDao;
import ua.petr.banking.model.Account;
import ua.petr.banking.model.Customer;
import ua.petr.banking.service.DefaultCustomerService;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class RestCustomerController {

    private DefaultCustomerService customerService;

    public RestCustomerController(DefaultCustomerService customerService){
        this.customerService = customerService;
    }

    @GetMapping()
    public List findAll() {
        return customerService.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {

        return customerService.getOne(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteById(@PathVariable Long id) {

        return customerService.deleteById(id);
    }

    @PostMapping("/delete")
    public boolean delete(@RequestBody Customer customer){
        return customerService.delete(customer);
    }

    @PostMapping("")
    public Customer save(@RequestBody Customer customer){
        customerService.save(customer);
        return customer;
    }
//    public List<Customer> listTemp = List.of(
//            new Customer("ivanov", "www", 11),
//            new Customer("sviridenko", "zxcv", 43)
//            );

    @PostMapping("/deleteall")
    public void deleteAll(@RequestBody List<Customer> list){
        customerService.deleteAll(list);

    }
    @PostMapping("/saveall")
    public void saveAll(@RequestBody List<Customer> list){
        customerService.saveAll(list);

    }

    @PutMapping("/{id}")
    public void update(@RequestBody Customer customer, @PathVariable long id){
        customerService.update(customer, id);
    }

//    Создать счет для конкретного пользователя
//    Удалить счет у пользователя
}
