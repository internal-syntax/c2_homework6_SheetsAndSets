package com.example.c2_homework6_sheetsandsets.controller;

import com.example.c2_homework6_sheetsandsets.Employee;
import com.example.c2_homework6_sheetsandsets.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getDepartmentMaximumWage (@RequestParam int departmentId) {
        return departmentService.getDepartmentMaximumWage(departmentId);
    }

    @GetMapping("/min-salary")
    public Employee getDepartmentMinimumWage (@RequestParam int departmentId) {
        return departmentService.getDepartmentMinimumWage(departmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection <Employee> getDataEmployeesDepartment (@RequestParam int departmentId) {
        return departmentService.getDataEmployeesDepartment(departmentId);
    }

    @GetMapping("/all")
    public Map <Integer, List <Employee>> sealDepartmentEmployees() {
        return departmentService.sealDepartmentEmployees();
    }
}
