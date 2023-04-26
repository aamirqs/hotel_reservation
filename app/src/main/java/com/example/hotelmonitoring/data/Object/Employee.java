package com.example.hotelmonitoring.data.Object;

import com.example.hotelmonitoring.data.Object.EmpRole;

public class Employee {
    private String employeeID;
    private String empFullName;
    private String empPhoneNumber;
    private EmpRole role;

    private String roleCode;

    public Employee(String employeeID, String fullName, String phoneNumber, EmpRole role) {
        this.employeeID = employeeID;
        this.empFullName = fullName;
        this.empPhoneNumber = phoneNumber;
        this.role = role;
    }

    public Employee(String employeeID, String fullName, String phoneNumber, String roleCode) {
        this.employeeID = employeeID;
        this.empFullName = fullName;
        this.empPhoneNumber = phoneNumber;
        this.roleCode = roleCode;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmpFullName() {
        return empFullName;
    }

    public void setEmpFullName(String fullName) {
        this.empFullName = fullName;
    }

    public String getEmpPhoneNumber() {
        return empPhoneNumber;
    }

    public void setEmpPhoneNumber(String phoneNumber) {
        this.empPhoneNumber = phoneNumber;
    }

    public EmpRole getRole() {
        return role;
    }

    public void setRole(EmpRole role) {
        this.role = role;
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }
}

