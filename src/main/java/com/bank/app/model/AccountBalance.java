package com.bank.app.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "accountbalance", schema = "account")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Getter
@Builder
public class AccountBalance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "serial")
    private int id;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "lastUpdateTimestamp")
    private String lastUpdateTimestamp;

    @Column(name = "balance")
    private Float balance;



}
