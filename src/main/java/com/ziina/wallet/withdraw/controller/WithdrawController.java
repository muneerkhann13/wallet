package com.ziina.wallet.withdraw.controller;

import com.ziina.wallet.withdraw.common.URIConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class WithdrawController {

    @RequestMapping(path = URIConstants.WITHDRAW_URI,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String withdraw(){
        return null;
    }
}
