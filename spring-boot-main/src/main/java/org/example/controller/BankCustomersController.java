package org.example.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.service.BankCustomersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Validated
@RestController
@RequestMapping("/api/1/bank-customers")
@Slf4j
public class BankCustomersController {

    @Autowired
    BankCustomersService bankCustomersService;

    @GetMapping(value = "/{customerName}", produces = {"application/json"})
    public String getCustomerMessage(@PathVariable("customerName") final String bankCustomerName) {
        log.info("In controller layer, request received for {} ", bankCustomerName);
        return bankCustomersService.getCustomerDetail(bankCustomerName);
    }


}
