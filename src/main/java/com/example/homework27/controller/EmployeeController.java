package com.example.homework27.controller;

import com.example.homework27.model.Employee;
import com.example.homework27.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addition(@RequestParam(value = "lastName", required = true) String lastName, @RequestParam(value = "firstName", required = true) String firstName) {
        return employeeService.addNewEmployee(lastName,firstName);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(value = "lastName", required = true) String lastName, @RequestParam(value = "firstName", required = true) String firstName) {
        return employeeService.removeEmployee(lastName,firstName);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(value = "lastName", required = true) String lastName, @RequestParam(value = "firstName", required = true) String firstName) {
        return employeeService.findEmployee(lastName,firstName);
    }

    @GetMapping("/list")
    public Map<String, Employee> list() {
        return employeeService.list();
    }
}
