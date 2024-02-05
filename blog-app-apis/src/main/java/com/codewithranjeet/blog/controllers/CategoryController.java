package com.codewithranjeet.blog.controllers;


import com.codewithranjeet.blog.payloads.ApiResponse;
import com.codewithranjeet.blog.payloads.CategoryDto;
import com.codewithranjeet.blog.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    //test api
    @RequestMapping("/test")
    public String hello() {
        return "category controller apis";
    }


    //create category
    @PostMapping("/addCategory")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    //update category
    @PutMapping("/{catId}")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto, @PathVariable Integer catId){
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto, catId);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/deleteCategory/{catId}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable Integer catId){
        this.categoryService.deleteCategory(catId);
        return new ResponseEntity<>(new ApiResponse("Category is delete successfully!!", true), HttpStatus.OK);
    }

    //get single Category by Id
    @GetMapping("/getCategory/{catId}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable Integer catId){
        CategoryDto categoryDto = this.categoryService.getCategory(catId);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }

    //get list of Category
    @GetMapping("/categoryList")
    public ResponseEntity<List<CategoryDto>> getAll(){
        List<CategoryDto> categoryList = this.categoryService.getCategories();
        return ResponseEntity.ok(categoryList);
    }
}
