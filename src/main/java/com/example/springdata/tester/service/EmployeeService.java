package com.example.springdata.tester.service;

import com.example.springdata.tester.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    void insertEmployee(Employee employee);
    void deleteEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void otherUpdateEmployee(Employee employee);
}
