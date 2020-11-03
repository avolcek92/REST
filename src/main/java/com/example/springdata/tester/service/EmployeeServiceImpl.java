package com.example.springdata.tester.service;

import com.example.springdata.tester.DAO.EmployeeDAO;
import com.example.springdata.tester.model.Employee;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Resource
    private EmployeeDAO employeeDAO;

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void insertEmployee(Employee employee) {
        employeeDAO.insertEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }

    @Override
    public void otherUpdateEmployee(Employee employee) {
        employeeDAO.otherUpdateEmployee(employee);
    }
}
