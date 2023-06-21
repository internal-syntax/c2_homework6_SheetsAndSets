package com.example.c2_homework6_sheetsandsets.service;

import com.example.c2_homework6_sheetsandsets.Employee;

import java.util.Collection;

public interface EmployeeServiceInterface {
    Employee addEmployee(String firstName, String lastName, int departmentId, int salary);

    Employee removeEmployee(String firstName, String lastName, int departmentId, int salary);

    Employee findEmployee(String firstName, String lastName, int departmentId, int salary);

    Collection<Employee> getEmployees();
}
