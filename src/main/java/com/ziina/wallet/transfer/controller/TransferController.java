package com.ziina.wallet.transfer.controller;

import com.ziina.wallet.transfer.common.URIConstants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TransferController {

    @RequestMapping(path = URIConstants.TRANSFER_URI,
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public String transfer(){
        return null;
    }
}
