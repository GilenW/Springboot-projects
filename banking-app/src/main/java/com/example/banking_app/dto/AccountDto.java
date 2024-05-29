package com.example.banking_app.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

//@Data
//public class AccountDto {
//
//    private Long id;
//    private String accountHolderName;
//    private double balance;
//
//    public AccountDto(Long id, String accountHolderName, double balance) {
//        this.id = id;
//        this.accountHolderName = accountHolderName;
//        this.balance = balance;
//    }
//
//    public Long getId() {
//        return id;
//    }
//
//    public String getAccountHolderName() {
//        return accountHolderName;
//    }
//
//    public double getBalance() {
//        return balance;
//    }
//}


public record AccountDto(Long id,
                         String accountHolderName,
                         double balance){

}


