package com.example.c2_homework6_sheetsandsets.service;

import com.example.c2_homework6_sheetsandsets.Employee;
import com.example.c2_homework6_sheetsandsets.exceptions.EmployeeAlreadyAddedException;
import com.example.c2_homework6_sheetsandsets.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService implements EmployeeServiceInterface {

    private final Map<String, Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    @Override
    public Employee addEmployee(String firstName, String lastName, int departmentId, int salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (employees.containsKey(employee.getFullName())) {
            throw new EmployeeAlreadyAddedException();
        }
        employees.put(employee.getFullName(), employee);
        return employee;
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName, int departmentId, int salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee.getFullName());
        return employee;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName, int departmentId, int salary) {
        Employee employee = new Employee(firstName, lastName, departmentId, salary);
        if (!employees.containsKey(employee.getFullName())) {
            throw new EmployeeNotFoundException();
        }
        return employee;
    }

    @Override
    public Collection<Employee> getEmployees() {
        return employees.values();
    }
}
