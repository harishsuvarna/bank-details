package com.bank.app.repository;

import com.bank.app.model.AccountBalance;
import com.bank.app.model.AccountDetails;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AccountRepository extends CrudRepository<AccountBalance, String> {

    @Query("select ab from AccountBalance ab where acctbalance.accountNumber = ?1")
    AccountBalance findAccountBalance(String accountNumber);

    @Query("select ac from acctdetails ac where acctdetails.accountNumber = ?1 and inbetween acctdetails.transactionTs1 = ?2 , transactionTs2 = ?3")
    List<AccountDetails> accountDetailsTimeFrame(String accountNumber, String transactionTs1, String transactionTs2 );


    @Query("select ac from acctdetails ac where acctdetails.accountNumber = ?1 and acctdetails.type = ?2")
    List<AccountDetails> accountDetails(String accountNumber, String type);

}
