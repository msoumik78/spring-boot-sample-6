package org.example;

import org.example.dao.DataHolder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankCustomersStarter {
    public static void main(String[] args) {
        SpringApplication.run(BankCustomersStarter.class, args);
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            BankCustomer bankCustomer1 = new BankCustomer("name1", 40, "kolkata", "wb", "developer");
            BankCustomer bankCustomer2 = new BankCustomer("name2", 42, "mumbai", "maharashtra", "developer");
            DataHolder.bankCustomerSimpleHashMap.put(bankCustomer1.name(), bankCustomer1);
            DataHolder.bankCustomerSimpleHashMap.put(bankCustomer2.name(), bankCustomer2);
            System.out.println("Initial data load completed");

        };
    }
}
