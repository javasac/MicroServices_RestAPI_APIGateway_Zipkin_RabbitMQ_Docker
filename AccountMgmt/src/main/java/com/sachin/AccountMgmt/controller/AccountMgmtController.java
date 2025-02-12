package com.sachin.AccountMgmt.controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountMgmtController
{
    @GetMapping("/check")
    public String status()
    {
        return "Account Management working.";
    }
}
