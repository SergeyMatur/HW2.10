package com.example.hw2_10.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class Employee {

    @JsonProperty("firstName")

    final String name;
    @JsonProperty("lastName")
    private final String surname;

    private final int department;
    private final double salary;

    public Employee(String name,
                    String surname,
                    int department,
                    double salary) {
        this.name = name;
        this.surname = surname;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }



    public String getSurname() {
        return surname;
    }

    public int getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }

    @Override
    public String toString() {
        return String.format("ФИ: %s, %s", surname, name);
    }
}
