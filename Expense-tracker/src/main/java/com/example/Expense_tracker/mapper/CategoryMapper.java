package com.example.Expense_tracker.mapper;

import com.example.Expense_tracker.dto.CategoryDto;
import com.example.Expense_tracker.entity.Category;

public class CategoryMapper {

    //map dto to entity
    public static Category mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.id(),
                categoryDto.name()
        );


    }

    public static CategoryDto mapToCategoryDto(Category category){
        return new CategoryDto(
                category.getId(),
                category.getName()
        );
    }
}
