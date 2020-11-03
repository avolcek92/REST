package com.example.springdata.tester.DAO;

import com.example.springdata.tester.mapper.EmployeeRowMapper;
import com.example.springdata.tester.model.Employee;
import org.springframework.jdbc.core.PreparedStatementCallback;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM employee";
    private static final String INSERT_EMPLOYEE = "insert into employee(employeeId, employeeName, employeeAddress," +
            "employeeEmail) values (:employeeId,:employeeName,:employeeAddress,:employeeEmail)";
    private static final String DELETE_EMPLOYEE = "delete from employee where employeeId = :employeeId";
    private static final String UPDATE_EMPLOYEE = "update employee set employeeName = :employeeName, employeeAddress = :employeeAddress, employeeEmail= :employeeEmail where employeeId = :employeeId ";

    private NamedParameterJdbcTemplate template;


    public EmployeeDAOImpl(NamedParameterJdbcTemplate template) {
        this.template = template;
    }

    @Override
    public List<Employee> findAll() {
        return template.query(SELECT_ALL_EMPLOYEE, new EmployeeRowMapper());
    }

    @Override
    public void insertEmployee(Employee employee) {
        String sql = INSERT_EMPLOYEE;
        KeyHolder holder = new GeneratedKeyHolder();
        SqlParameterSource params = generateInsertSqlParams(employee);
        template.update(sql, params, holder);

    }

    @Override
    public void updateEmployee(Employee employee) {
        SqlParameterSource params = generateInsertSqlParams(employee);
        template.update(UPDATE_EMPLOYEE, params, new GeneratedKeyHolder());

    }

    @Override
    public void otherUpdateEmployee(Employee employee) {
        Map<String, Object> map = new HashMap<>();
        map.put("employeeId", employee.getEmployeeId());
        map.put("employeeName", employee.getEmployeeName());
        map.put("employeeAddress", employee.getEmployeeAddress());
        map.put("employeeEmail", employee.getEmployeeEmail());
        template.execute(UPDATE_EMPLOYEE, map, (PreparedStatementCallback<Object>) PreparedStatement::executeUpdate);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        Map<String, Object> map = new HashMap<>();
        map.put("employeeId", employee.getEmployeeId());
        template.execute(DELETE_EMPLOYEE, map, (PreparedStatementCallback<Object>) PreparedStatement::executeUpdate);


    }

    private SqlParameterSource generateInsertSqlParams(Employee employee) {
        return new MapSqlParameterSource()
                .addValue("employeeId", employee.getEmployeeId())
                .addValue("employeeName", employee.getEmployeeName())
                .addValue("employeeAddress", employee.getEmployeeAddress())
                .addValue("employeeEmail", employee.getEmployeeEmail());
    }
}
