package com.example.homework28.service;

import com.example.homework28.model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Optional maxSalary(Integer departmentId) {
        return employeeService.list().values().stream()
                .filter(e -> Objects.equals(e.getDepartment(), departmentId))
                .max(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public Optional minSalary(Integer departmentId) {
        return employeeService.list().values().stream()
                .filter(e -> Objects.equals(e.getDepartment(), departmentId))
                .min(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public List<Map> departmentEmployees(Integer departmentId) {

        return List.of(Map.of(departmentId, employeeService.list().values().stream()
                .filter(e -> Objects.equals(e.getDepartment(), departmentId))
                .collect(Collectors.toList())));
    }

    @Override
    public List<Map> allEmployees() {
        Set <Integer> departments = employeeService.list().values().stream()
                .map(Employee::getDepartment)
                .collect(Collectors.toSet());
        List<Map> allEmployees = new ArrayList<>();
        departments.stream().forEach(d -> {
            allEmployees.add(Map.of(d, employeeService.list().values().stream()
                    .filter(e -> Objects.equals(e.getDepartment(), d))
                    .collect(Collectors.toList())));
                }
        );
        return allEmployees;
    }
}
