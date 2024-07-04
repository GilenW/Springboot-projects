package com.example.Expense_tracker.service;

import com.example.Expense_tracker.dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto getExprenseById(Long expenseId);
    List<ExpenseDto> getAllExpenses();
    ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);
    void deleteExpense(Long expenseId);

}
