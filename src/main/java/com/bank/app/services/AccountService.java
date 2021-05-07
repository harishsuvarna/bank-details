package com.bank.app.services;

import com.bank.app.model.AccountBalance;
import com.bank.app.model.AccountDetails;

import java.util.List;

public interface AccountService {

    AccountBalance findAccountBalance(String acctNbr) throws Exception;

    List<AccountDetails> accountDetailsTimeFrame(String acctNbr, String timeStart, String timeEnd) throws Exception;

    List<AccountDetails> accountDetails(String acctNbr, String Type) throws Exception;
}
