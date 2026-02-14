package com.app.performtrackapi.controllers;

import com.app.performtrackapi.dtos.Sub_department.SubDepartmentDto;
import com.app.performtrackapi.services.Sub_department.sub_departmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/sub-department")
public class SubDepartmentController {

    private final sub_departmentService sub_departmentService;
    public SubDepartmentController(sub_departmentService sub_departmentService) {
        this.sub_departmentService = sub_departmentService;
    }

    @GetMapping("/{subDepartmentId}")
    public ResponseEntity<SubDepartmentDto> getById(@PathVariable UUID subDepartmentId){
        SubDepartmentDto subDepartmentDto = sub_departmentService.getSubDepartmentById(subDepartmentId);
        return ResponseEntity.ok(subDepartmentDto);
    }

    @GetMapping("/department/{departmentId}")
    public ResponseEntity<SubDepartmentDto> getByDepartmentId(@PathVariable UUID departmentId){
        SubDepartmentDto subDepartmentDto = sub_departmentService.getSubDepartmentByDepartmentId(departmentId);
        return ResponseEntity.ok(subDepartmentDto);
    }

    @PostMapping("/")
    public ResponseEntity<SubDepartmentDto> createSubDepartment(@RequestBody SubDepartmentDto subDepartmentDto){
        return new ResponseEntity<>(sub_departmentService.createSubDepartment(subDepartmentDto), HttpStatus.CREATED);
    }

    @PatchMapping("/{subDepartmentId}")
    public ResponseEntity<SubDepartmentDto> updateSubDepartment(@PathVariable UUID subDepartmentId, @RequestBody SubDepartmentDto subDepartmentDto){
        return ResponseEntity.ok(sub_departmentService.updateSubDepartment(subDepartmentId, subDepartmentDto));
    }

    @GetMapping("/")
    public ResponseEntity<List<SubDepartmentDto>> getAllSubDepartments(){
        List<SubDepartmentDto> subDepartments = sub_departmentService.getAllSubDepartments();
        if(subDepartments.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subDepartments);
    }

    @DeleteMapping("/{subDepartmentId}")
    public ResponseEntity<Void> deleteSubDepartment(@PathVariable UUID subDepartmentId){
        sub_departmentService.deleteSubDepartment(subDepartmentId);
        return ResponseEntity.noContent().build();
    }
}
