package com.example.springdata.tester.controller;

import com.example.springdata.tester.model.Employee;
import com.example.springdata.tester.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ApplicationController {

    @Resource
    private EmployeeService employeeService;

    @GetMapping("/empList")
    public List<Employee> getEmployees() {
        return employeeService.findAll();
    }

    @PostMapping("/create")
    public void createEmployee(@RequestBody Employee employee) {
        employeeService.insertEmployee(employee);
    }

    @DeleteMapping("/delete")
    public void deleteEmployee(@RequestBody Employee employee) {
        employeeService.deleteEmployee(employee);
    }

    @PutMapping("/update")
    public void updateEmployee(@RequestBody Employee employee) {
        employeeService.updateEmployee(employee);
    }

    @PutMapping("/otherupdate")
    public void otherUpdateEmployee(@RequestBody Employee employee) {
        employeeService.otherUpdateEmployee(employee);
    }


}
