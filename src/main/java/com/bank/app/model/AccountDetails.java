package com.bank.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accountdetails", schema = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class AccountDetails implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "transactionTs")
    private String transactionTs;

    @Column(name = "type")
    private String type;

    @Column(name = "amount")
    private Float amount;

    




}
