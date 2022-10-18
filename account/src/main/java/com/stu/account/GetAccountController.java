package com.stu.account;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class GetAccountController {

    @GetMapping("/getAccount")
    public String getAccount() {
        return "account1";
    }
}
