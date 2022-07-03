package com.example.homework27.service;
import com.example.homework27.model.Employee;
import java.util.Map;

public interface EmployeeService {

    Employee addNewEmployee(String lastName, String firstName);
    Employee findEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);
    Map<String, Employee> list();
}
