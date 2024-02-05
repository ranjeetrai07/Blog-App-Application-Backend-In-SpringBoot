package com.codewithranjeet.blog.repositories;

import com.codewithranjeet.blog.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Integer> {
}
