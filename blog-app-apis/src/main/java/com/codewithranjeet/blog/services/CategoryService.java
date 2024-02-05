package com.codewithranjeet.blog.services;

import com.codewithranjeet.blog.payloads.CategoryDto;
import com.codewithranjeet.blog.repositories.CategoryRepo;

import java.util.List;

public interface CategoryService {

    //create category
    CategoryDto createCategory(CategoryDto categoryDto);

    //update category
    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    //delete category
    void deleteCategory(Integer categoryId);

    //get single category by id
    CategoryDto getCategory(Integer categoryId);

    //get list of category
    List<CategoryDto> getCategories();
}
