package com.example.c2_homework6_sheetsandsets.controller;

import com.example.c2_homework6_sheetsandsets.Employee;
import com.example.c2_homework6_sheetsandsets.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String showHello() {
        return "<b>Добро пожаловать в программу учёта сотрудников</b>";
    }

    @GetMapping("/add")
    public Employee add (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam int salary) {
        return employeeService.addEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/remove")
    public Employee remove (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam int salary) {
        return employeeService.removeEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/find")
    public Employee find (@RequestParam String firstName, @RequestParam String lastName, @RequestParam int departmentId, @RequestParam int salary) {
        return employeeService.findEmployee(firstName, lastName, departmentId, salary);
    }

    @GetMapping("/list")
    public Collection<Employee> getEmployees() {
        return employeeService.getEmployees();
    }
}
