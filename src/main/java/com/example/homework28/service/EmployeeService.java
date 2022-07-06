package com.example.homework28.service;
import com.example.homework28.model.Employee;
import java.util.Map;

public interface EmployeeService {

    Employee addNewEmployee(String lastName, String firstName, Integer salary, Integer department);
    Employee findEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);
    Map<String, Employee> list();
}
