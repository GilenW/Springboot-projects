package com.example.Expense_tracker.mapper;

import com.example.Expense_tracker.dto.CategoryDto;
import com.example.Expense_tracker.dto.ExpenseDto;
import com.example.Expense_tracker.entity.Category;
import com.example.Expense_tracker.entity.Expense;

public class ExpenseMapper {


    public static ExpenseDto mapToExpenseDto(Expense expense){
        return new ExpenseDto(
                expense.getId(),
                expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }


    public static Expense mapToExpense(ExpenseDto expenseDto){
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());

        return new Expense(
                expenseDto.id(),
                expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }
}
