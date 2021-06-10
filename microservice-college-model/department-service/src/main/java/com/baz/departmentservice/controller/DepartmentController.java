package com.baz.departmentservice.controller;

import com.baz.departmentservice.entities.Department;
import com.baz.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    public String homePage() {
        return "Hi! I am Baz.";
    }
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("inside saveDepartment method of departmentController");
        return departmentService.saveDepartment(department);
    }
    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable("id") Long departmentId) {
        log.info("Inside findDepartmentById method of departmentCcntroller");
        return departmentService.findDepartmentById(departmentId);
    }

}
