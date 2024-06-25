package com.example.Expense_tracker.controller;

import com.example.Expense_tracker.dto.ExpenseDto;
import com.example.Expense_tracker.entity.Expense;
import com.example.Expense_tracker.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {


    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody
                                                    ExpenseDto expenseDto){
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }


    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable("id") Long expenseId){
        ExpenseDto expenseDto = expenseService.getExprenseById(expenseId);
        return ResponseEntity.ok(expenseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenseDtos = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseDtos);
    }

    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id")
                                                    Long expenseId, @RequestBody ExpenseDto
                                                    expenseDto){
        ExpenseDto updatedExpense = expenseService.updateExpense(expenseId, expenseDto);

        return ResponseEntity.ok(updatedExpense);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> delete(@PathVariable("id")Long expenseId){
        expenseService.deleteExpense(expenseId);
        return ResponseEntity.ok("Expense deleted successfully!");

    }


}
