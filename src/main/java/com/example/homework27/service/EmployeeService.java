package com.example.homework27.service;

import com.example.homework27.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee addNewEmployee(String lastName, String firstName);
    Employee findEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);
    List<Employee> list();
}
