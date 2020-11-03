package com.example.springdata.tester.DAO;

import com.example.springdata.tester.model.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    void insertEmployee(Employee employee);
    void updateEmployee(Employee employee);
    void otherUpdateEmployee(Employee employee);
    void deleteEmployee(Employee employee);
}
