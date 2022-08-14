package com.example.hw2_10.controller;


import com.example.hw2_10.model.Employee;
import com.example.hw2_10.service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname,
                                @RequestParam("department") int department,
                                @RequestParam("salary") double salary) {
        return employeeService.add(name, surname, department, salary);
    }
    @GetMapping("/find")
    public Employee findEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname) {
        return employeeService.findEmployee(name, surname);

    }
    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam("firstName") String name,
                                @RequestParam("lastName") String surname) {
        return employeeService.removeEmployee(name, surname);
    }
    @GetMapping("/all")
    public List<Employee> getAll() {
        return EmployeeService.getAll();

    }
}
