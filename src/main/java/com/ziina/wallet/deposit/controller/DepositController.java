package com.ziina.wallet.deposit.controller;

import com.ziina.wallet.deposit.common.URIConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DepositController {

    @RequestMapping(path = URIConstants.DEPOSIT_URI,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String deposit(){
        return null;
    }
}
