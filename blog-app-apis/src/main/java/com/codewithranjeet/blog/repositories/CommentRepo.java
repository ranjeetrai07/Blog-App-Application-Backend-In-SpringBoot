package com.codewithranjeet.blog.repositories;

import com.codewithranjeet.blog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Integer> {
}
