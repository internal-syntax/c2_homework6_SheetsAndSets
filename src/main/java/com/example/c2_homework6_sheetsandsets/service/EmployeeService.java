package com.example.c2_homework6_sheetsandsets.service;

import com.example.c2_homework6_sheetsandsets.Employee;
import com.example.c2_homework6_sheetsandsets.exceptions.EmployeeAlreadyAddedException;
import com.example.c2_homework6_sheetsandsets.exceptions.EmployeeNotFoundException;
import com.example.c2_homework6_sheetsandsets.exceptions.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    private static final Integer EMPLOYEES_SIZE = 10;

    private final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
        if (employees.size() >= EMPLOYEES_SIZE) {
            throw new EmployeeStorageIsFullException();
        }
        Employee employee = new Employee(firstName, lastName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.add(employee);
        return employee;
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
