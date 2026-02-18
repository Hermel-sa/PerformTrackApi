package com.app.performtrackapi.controllers;

import com.app.performtrackapi.dtos.Employee.EmployeeDto;
import com.app.performtrackapi.dtos.Employee.EmployeeResponseDto;
import com.app.performtrackapi.services.Employee.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeById(@PathVariable UUID employeeId){
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/position/{positionId}")
    public ResponseEntity<EmployeeResponseDto> getEmployeeByPositionId(@PathVariable UUID positionId){
        return ResponseEntity.ok(employeeService.getEmployeeByPositionId(positionId));
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeResponseDto>> getAllEmployees(){
        List<EmployeeResponseDto> employee = employeeService.getAllEmployee();
        return ResponseEntity.ok(employee);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeResponseDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
        return new ResponseEntity<>(employeeService.createEmployee(employeeDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{employeeId}")
    public ResponseEntity<EmployeeResponseDto> updateEmployee(@PathVariable UUID employeeId, @RequestBody EmployeeDto employeeDto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employeeDto));
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable UUID employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.noContent().build();
    }
}
