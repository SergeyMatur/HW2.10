package com.example.hw2_10.service;


import com.example.hw2_10.exception.EmployeeAlreadyAddedException;
import com.example.hw2_10.exception.EmployeeNotFoundException;
import com.example.hw2_10.exception.EmployeeStorageIsFullException;
import com.example.hw2_10.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

    private static int LIMIT = 10;
    private static final List<Employee> employees = new ArrayList<>();
    private final ValidatorService validatorService;

    public EmployeeService(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }


    public Employee add(String name,
                                String surname,
                                int department,
                                double salary) {
        Employee employee = new Employee(
                validatorService.validateName(name),
                validatorService.validateSurname(surname),
                department,
                salary
        );
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < LIMIT) {
            employees.add(employee);
            return employee;
        }
        throw new EmployeeStorageIsFullException();
    }

    public Employee findEmployee(String name, String surname) {
        Employee employee = employees.stream()
                .filter(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        return employee;
    }

    public Employee removeEmployee(String name, String surname) {
        Employee employee = employees.stream()
                .filter(emp -> emp.getName().equals(name) && emp.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(EmployeeNotFoundException::new);
        employees.remove(employee);
        return employee;
    }

    public static List<Employee> getAll() {
        return new ArrayList<>(employees);
    }



}
