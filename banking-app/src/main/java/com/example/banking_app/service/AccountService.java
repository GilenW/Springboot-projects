package com.example.banking_app.service;

import com.example.banking_app.dto.AccountDto;
import com.example.banking_app.dto.TransactionDto;
import com.example.banking_app.dto.TransferFundDto;

import java.util.List;

public interface AccountService {
    AccountDto createAccount(AccountDto account);

    AccountDto getAccountById(Long id);

    AccountDto deposit(Long id, double amount);

    AccountDto withdraw(Long id, double amount);

    List<AccountDto> getAllAccounts();

    void deleteAccount(Long id);

    void transferFunds(TransferFundDto transferFundDto);

    List<TransactionDto> getAccountTransactions(Long accountId);
}
