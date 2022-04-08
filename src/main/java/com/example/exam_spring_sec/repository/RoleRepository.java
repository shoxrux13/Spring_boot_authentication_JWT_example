package com.example.exam_spring_sec.repository;

import com.example.exam_spring_sec.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Integer> {
}
