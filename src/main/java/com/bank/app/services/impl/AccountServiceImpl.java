package com.bank.app.services.impl;

import com.bank.app.model.AccountBalance;
import com.bank.app.model.AccountDetails;
import com.bank.app.repository.AccountRepository;
import com.bank.app.services.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountBalance findAccountBalance(String acctNbr) throws Exception {
        return (AccountBalance) accountRepository.findAccountBalance("acctNbr");
    }

    @Override
    public List<AccountDetails> accountDetailsTimeFrame(String acctNbr, String timeStart, String timeEnd) throws Exception {
        return (List<AccountDetails>) accountRepository.accountDetailsTimeFrame("acctNbr", "timeStart", "timeEnd");
    }

    @Override
    public List<AccountDetails> accountDetails(String acctNbr, String Type) throws Exception {
        return (List<AccountDetails>) accountRepository.accountDetails("acctNbr","Type");
    }

}