package com.example.c2_homework6_sheetsandsets.service;

import com.example.c2_homework6_sheetsandsets.Employee;
import com.example.c2_homework6_sheetsandsets.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.groupingBy;

@Service
public class DepartmentService implements DepartmentServiceInterface {

    private final EmployeeService employeeService;

    public DepartmentService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getDepartmentMaximumWage(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .max(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Employee getDepartmentMinimumWage(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .min(comparingInt(Employee::getSalary))
                .orElseThrow(EmployeeNotFoundException::new);
    }

    @Override
    public Collection<Employee> getDataEmployeesDepartment(int departmentId) {
        return employeeService.getEmployees().stream()
                .filter(e -> e.getDepartment() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> sealDepartmentEmployees() {
        return employeeService.getEmployees().stream()
                .collect(groupingBy(Employee::getDepartment));
    }
}
