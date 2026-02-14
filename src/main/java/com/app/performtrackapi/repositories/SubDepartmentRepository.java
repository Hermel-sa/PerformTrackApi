package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.Sub_department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SubDepartmentRepository extends JpaRepository<Sub_department, UUID> {
    Sub_department findByDepartmentId(UUID departmentId);
    Boolean existsByName(String name);
}
