package com.codewithranjeet.blog.services.impl;


import com.codewithranjeet.blog.entities.Category;
import com.codewithranjeet.blog.exceptions.ResourceNotFoundException;
import com.codewithranjeet.blog.payloads.CategoryDto;
import com.codewithranjeet.blog.repositories.CategoryRepo;
import com.codewithranjeet.blog.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService{

    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = this.modelMapper.map(categoryDto, Category.class);
        Category addedCat = this.categoryRepo.save(category);
        return this.modelMapper.map(addedCat, CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category catgry = this.categoryRepo.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        catgry.setCategoryTitle(categoryDto.getCategoryTitle());
        catgry.setCategoryDescription(categoryDto.getCategoryDescription());
        Category updatedCatgry = this.categoryRepo.save(catgry);
        return this.modelMapper.map(updatedCatgry, CategoryDto.class);
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Category catgry = this.categoryRepo.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
    }

    @Override
    public CategoryDto getCategory(Integer categoryId) {
        Category catgry = this.categoryRepo.findById(categoryId).
                orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        return this.modelMapper.map(catgry, CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = this.categoryRepo.findAll();
        List<CategoryDto> categoryDtos = categories.stream().
                map((cat) ->  this.modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return categoryDtos;
    }
}
