package org.example.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BankCustomersService {

    public String getCustomerDetail(String bankCustomerName) {
        log.info("In service layer, request received for {} ", bankCustomerName);
        return "Hello "+bankCustomerName;
    }

}
