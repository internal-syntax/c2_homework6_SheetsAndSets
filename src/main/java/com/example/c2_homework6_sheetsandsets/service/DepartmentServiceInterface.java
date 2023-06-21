package com.example.c2_homework6_sheetsandsets.service;

import com.example.c2_homework6_sheetsandsets.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
    Employee getDepartmentMaximumWage(int departmentId);

    Employee getDepartmentMinimumWage(int departmentId);

    Collection <Employee> getDataEmployeesDepartment(int departmentId);

    Map <Integer, List <Employee>> sealDepartmentEmployees();

}
