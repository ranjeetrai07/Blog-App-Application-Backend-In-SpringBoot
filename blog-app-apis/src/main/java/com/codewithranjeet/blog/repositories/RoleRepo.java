package com.codewithranjeet.blog.repositories;

import com.codewithranjeet.blog.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Integer> {
}
