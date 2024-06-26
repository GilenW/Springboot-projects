package com.example.Expense_tracker.service.impl;

import com.example.Expense_tracker.dto.ExpenseDto;
import com.example.Expense_tracker.entity.Category;
import com.example.Expense_tracker.entity.Expense;
import com.example.Expense_tracker.exceptions.ResourceNotFoundException;
import com.example.Expense_tracker.mapper.ExpenseMapper;
import com.example.Expense_tracker.repository.CategoryRepository;
import com.example.Expense_tracker.repository.ExpenseRepository;
import com.example.Expense_tracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private ExpenseRepository expenseRepository;
    private CategoryRepository categoryRepository;
    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {

        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExprenseById(Long expenseId) {

        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(()->new ResourceNotFoundException("expense not found with id: " +
                        expenseId));

        return ExpenseMapper.mapToExpenseDto(expense);

    }

    @Override
    public List<ExpenseDto> getAllExpenses() {

        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::mapToExpenseDto)
                .collect(Collectors.toList());

    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(()->new ResourceNotFoundException(
                        "expense not found with id: " + expenseId
                ));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());

        if(expenseDto.categoryDto()!=null){
            Category category = categoryRepository.findById(expenseDto.categoryDto().id())
                    .orElseThrow(()->new ResourceNotFoundException("Cateogry not found with id: "
                    + expenseDto.categoryDto().id()));
            expense.setCategory(category);

        }
        Expense updatedExpense = expenseRepository.save(expense);

        return ExpenseMapper.mapToExpenseDto(updatedExpense);


    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: "
                + expenseId));
        expenseRepository.delete(expense);


    }
}
