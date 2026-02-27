package com.app.performtrackapi.repositories;

import com.app.performtrackapi.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {
    boolean existsById(UUID id);
    Employee findByPositionId(UUID positionId);
    java.util.Optional<Employee> findByUser(com.app.performtrackapi.entities.User user);
}
