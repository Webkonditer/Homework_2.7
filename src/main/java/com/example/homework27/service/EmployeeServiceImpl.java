package com.example.homework27.service;

import com.example.homework27.model.Employee;
import com.example.homework27.exception.EmployeeAlreadyAddedException;
import com.example.homework27.exception.EmployeeNotFoundException;
import com.example.homework27.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
   // private Employee egorovEgor = new Employee("Егоров", "Егор");

    private Map<String, Employee> employees = new HashMap<>(Map.of(
            "Егоров Егор", new Employee("Егоров", "Егор")




    ));

    private final int employeeNum = 10;

    @Override
    public Employee addNewEmployee(String lastName, String firstName) {

        if (employees.size() >= employeeNum){
            throw new EmployeeStorageIsFullException("Все вакансии заняты");
        }
        if (employees.containsKey(lastName + " " + firstName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        Employee employee = new Employee(lastName, firstName);
        employees.put(lastName + " " + firstName, employee);
        return employee;
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {

        if (employees.containsKey(lastName + " " + firstName)) {
            return employees.get(lastName + " " + firstName);
        }

        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {

        if (employees.containsKey(lastName + " " + firstName)) {
            Employee employee = employees.get(lastName + " " + firstName);
            employees.remove(lastName + " " + firstName);
            return employee;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден. Удаление невозможно.");
    }

    @Override
    public Map<String, Employee> list() {
        Map list = new HashMap();
        list.putAll(employees);
        return list;
    }
}

