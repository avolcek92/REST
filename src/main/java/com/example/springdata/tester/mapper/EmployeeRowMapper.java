package com.example.springdata.tester.mapper;

import com.example.springdata.tester.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet resultSet, int i) throws SQLException {
        Employee employee = new Employee();
        employee.setEmployeeId(resultSet.getString("employeeId"));
        employee.setEmployeeName(resultSet.getString("employeeName"));
        employee.setEmployeeEmail(resultSet.getString("employeeEmail"));
        employee.setEmployeeAddress(resultSet.getString("employeeAddress"));
        return employee;
    }
}
