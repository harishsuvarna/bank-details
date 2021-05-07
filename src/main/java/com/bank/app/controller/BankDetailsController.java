package com.bank.app.controller;


import com.bank.app.model.AccountBalance;
import com.bank.app.model.AccountDetails;
import com.bank.app.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class BankDetailsController {

    @Autowired
    AccountService AccountService;



     /**
     * Given an accountNumber, return the latest balance.
     */

    @GetMapping("/account/balance")
    public Float getAccountBalance(
            @RequestParam (name = "accountNumber", required =false ) String accountNumber) {
        AccountBalance acctBalance = null;
        try {
            acctBalance = AccountService.findAccountBalance(accountNumber);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return acctBalance.getBalance();



    }


    //2.Given an accountNumber and a time range such as: Today, Last 7 days, last Month and the more general case of a range between date X and date Y. For example, I should be able to ask for all my transactions between January 8th, 2019 and November 28th, 2020.
    //Repeat 2, but filter for type. I.E. Show me transactions with type WITHDRAW.
    @GetMapping("/account/details/timerange")
    public List<AccountDetails>  getAccountDetails(
            @RequestParam (name = "accountNumber", required =false ) String accountNumber,
            @RequestParam (name = "TimeStart", required =false ) String timeStart ,
            @RequestParam (name = "TimeEnd", required =false ) String timeEnd ,
            @RequestParam (name = "Type", required =false ) String type) {
        List<AccountDetails> acctDetails =  null;

        try {
            LocalTime time = LocalTime.now();
            String startTime = Optional.ofNullable("timeStart").orElse(time.toString());
           acctDetails = AccountService.accountDetailsTimeFrame(accountNumber, startTime, timeEnd);

            return type==null? acctDetails:acctDetails.stream().filter(cd ->cd.getType().equalsIgnoreCase(type)).collect(Collectors.toList());


        } catch (Exception e) {
            e.printStackTrace();
        }
        return acctDetails;

    }








}
