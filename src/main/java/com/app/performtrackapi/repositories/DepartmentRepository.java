package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, UUID> {
    Boolean existsByName(String name);
}
