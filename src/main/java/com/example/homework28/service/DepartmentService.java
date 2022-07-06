package com.example.homework28.service;

import com.example.homework28.model.Employee;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DepartmentService {
    Optional maxSalary(Integer departmentId);

    Optional minSalary(Integer departmentId);

    List<Map> departmentEmployees(Integer departmentId);

    List<Map> allEmployees();
}
