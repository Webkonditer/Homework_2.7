package com.example.homework28.controller;

import com.example.homework28.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/departments")

public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Optional maxSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.maxSalary(departmentId);
    }

    @GetMapping("/min-salary")
    public Optional minSalary(@RequestParam("departmentId") Integer departmentId) {
        return departmentService.minSalary(departmentId);
    }

    @GetMapping("/all")
    public List<Map> departmentEmployees(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        if(departmentId != null){
            return departmentService.departmentEmployees(departmentId);
        } else {
            return departmentService.allEmployees();
        }

    }

}
