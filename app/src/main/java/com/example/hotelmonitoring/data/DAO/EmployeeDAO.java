package com.example.hotelmonitoring.data.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.hotelmonitoring.data.Object.Employee;

public class EmployeeDAO {
    private Connection connection;

    public EmployeeDAO(Connection connection) {
        this.connection = connection;
    }

    public void addEmployee(Employee employee) throws SQLException {
        String sql = "INSERT INTO Employee (Employee_ID, Emp_Full_Name, Emp_Phone_Num, Role_Code) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getEmployeeID());
            statement.setString(2, employee.getEmpFullName());
            statement.setString(3, employee.getEmpPhoneNumber());
            statement.setString(4, employee.getRoleCode());
            statement.executeUpdate();
        }
    }

    public void updateEmployee(Employee employee) throws SQLException {
        String sql = "UPDATE Employee SET Emp_Full_Name = ?, Emp_Phone_Num = ?, Role_Code = ? WHERE Employee_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getEmpFullName());
            statement.setString(2, employee.getEmpPhoneNumber());
            statement.setString(3, employee.getRoleCode());
            statement.setString(4, employee.getEmployeeID());
            statement.executeUpdate();
        }
    }

    public void deleteEmployee(Employee employee) throws SQLException {
        String sql = "DELETE FROM Employee WHERE Employee_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employee.getEmployeeID());
            statement.executeUpdate();
        }
    }

    public Employee getEmployeeById(String employeeId) throws SQLException {
        String sql = "SELECT * FROM Employee WHERE Employee_ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, employeeId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String empFullName = resultSet.getString("Emp_Full_Name");
                String empPhoneNumber = resultSet.getString("Emp_Phone_Num");
                String roleCode = resultSet.getString("Role_Code");
                return new Employee(employeeId, empFullName, empPhoneNumber, roleCode);
            } else {
                return null;
            }
        }
    }

    public List<Employee> getAllEmployees() throws SQLException {
        String sql = "SELECT * FROM Employee";
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(sql);
            List<Employee> employees = new ArrayList<>();
            while (resultSet.next()) {
                String employeeId = resultSet.getString("Employee_ID");
                String empFullName = resultSet.getString("Emp_Full_Name");
                String empPhoneNumber = resultSet.getString("Emp_Phone_Num");
                String roleCode = resultSet.getString("Role_Code");
                employees.add(new Employee(employeeId, empFullName, empPhoneNumber, roleCode));
            }
            return employees;
        }
    }
}

