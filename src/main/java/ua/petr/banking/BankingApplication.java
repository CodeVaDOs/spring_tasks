package ua.petr.banking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.petr.banking.enums.Currency;
import ua.petr.banking.model.Account;
import ua.petr.banking.model.Customer;

@SpringBootApplication
public class BankingApplication {


	public static void main(String[] args) {
		SpringApplication.run(BankingApplication.class, args);
//		Customer customer1 = new Customer("sam", "qwwry", 33);
//		Customer customer2 = new Customer("Viki", "prof", 22);
//
//		Account account1 = new Account(Currency.EUR, customer1);
//		Account account2 = new Account(Currency.USD, customer2);
//
//		System.out.println(account1);
//		System.out.println(account2);

	}


}
